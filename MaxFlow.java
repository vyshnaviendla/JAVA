/*

In the max flow problem, we have a directed graph with a source node s and a sink node t, and each edge has a capacity that represents the maximum amount of flow that can be sent through it. The goal is to find the maximum amount of flow that can be sent from s to t, while respecting the capacity constraints on the edges.

input format :
			an integer n (number of nodes)
			adjacency matrix
output format : an integer


Sample Input:
------------------
6
0 16 13 0 0 0
0 0 10 12 0 0
0 4 0 0 14 0
0 0 9 0 0 20
0 0 0 7 0 4
0 0 0 0 0 0
0 5


Sample Output:
--------------------
23

Sample input 
-------------------
6
0 7 4 0 0 0
0 0 0 5 3 0
0 3 0 0 2 0
0 0 0 0 0 8
0 0 0 3 0 5
0 0 0 0 0 0
0 5

Sample Output:
--------------------
10
*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxFlow{
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cap = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cap[i][j] = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        System.out.println(maxFlow(n, cap, s, t));
    }
    static int maxFlow(int n, int[][] cap, int s, int t){
        int flow = 0;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            res[i] = Arrays.copyOf(cap[i], n);
        int[] par = new int[n];
        while (bfs(res, s, t, par)){
            int f = INF;
            for (int v = t; v != s; v = par[v])
                f = Math.min(f, res[par[v]][v]);
            for (int v = t; v != s; v = par[v]){
                int u = par[v];
                res[u][v] -= f;
                res[v][u] += f;
            }
            flow += f;
        }
        return flow;
}
    static boolean bfs(int[][] res, int s, int t, int[] par){
        int n = res.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        par[s] = -1;
        while (!q.isEmpty()){
            int u = q.poll();
            for (int v = 0; v < n; v++){
                if (!vis[v] && res[u][v] > 0){
                    q.add(v);
                    par[v] = u;
                    vis[v] = true;
                    if (v == t) return true;
                }
            }
        }
        return false;
    }
}