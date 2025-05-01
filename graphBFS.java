// You are given an undirected graph represented by n nodes numbered from 0 to n-1, and a list of e edges, where each edge connects two nodes.

// Your task is to implement a program that calculates the total number of connected components in the graph. 
// A connected component is a group of nodes such that there is a path between any two nodes with in the group
// and no node in the group is connected to any node outside of it.

// Your program should use Breadth-First Search (BFS) to explore the graph.

// Input Format:
// ------------

// - The first line contains two integers n and e — the number of nodes and edges.
// - The next e lines each contain two integers u and v, indicating that there is an undirected edge between node u and node v.

// Output Format:
// --------------
// - Output a single integer — the number of connected components in the graph.

// Constraints:
// ------------
// - 1≤ n ≤10000 
// - 0≤ e ≤100000 
// - 0≤ u,v <n

// Example Input:
// -------------
// 6 4
// 0 1
// 1 2
// 3 4
// 4 5

// Example Output:
// --------------
// 2

// Explanation:
// ------------
// There are two connected components in the graph:

// - Component 1: {0, 1, 2}
// - Component 2: {3, 4, 5}






import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class graphBFS{
    public static int countComponents(int n, List<int[]> edges){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int componentCount = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                bfs(i, graph, visited);
                componentCount++;
            }
        }
        return componentCount;
    }
    private static void bfs(int start, List<List<Integer>> graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbor : graph.get(node)){
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int e = sc.nextInt();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.add(new int[]{u, v});
        }
        int result = countComponents(n, edges);
        System.out.println(result);
    }

}