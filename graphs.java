// you are given an undirected graph with n nodes labeled from 0 to n - 1 and a list of e edges where each edge connects two nodes. 
// Your task is to determine the number of connected components in the graph.

// A connected component is a set of nodes such that there is a path between any two nodes in this set
// and the set is not connected to any other node outside it.

// Input Format:
// -----------
// - An integer n representing the number of nodes in the graph.
// - An integer e representing the number of edges.
// - e lines follow, each containing two integers u and v representing an undirected edge between node u and node v.

// Output Format:
// -------------
// - A single integer representing the number of connected components in the graph.

// Constraints:
// -------------
// - 1 <= n <= 2000
// - 0 <= e <= n * (n - 1) / 2
// - 0 <= u, v < n
// - No duplicate edges or self-loops.

// Sample Input:
// -------------
// 5
// 3
// 0 1
// 1 2
// 3 4

// Sample Output:
// --------------
// 2

// Explanation:
// -------------
// - Component 1: Nodes 0, 1, 2 are connected.
// - Component 2: Nodes 3 and 4 are connected.
// - Node 5 is not part of any edge and forms its own component if n were larger.



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graphs{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int e = sc.nextInt(); 
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
            }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i, graph, visited);
                components++;
            }
        }
        System.out.println(components);
        sc.close();
    }
    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        for (int neighbor : graph.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor, graph, visited);
            }
        }
    }
}