// Given an undirected, connected graph, identify all articulation points in the graph.

// An articulation point (or cut vertex) is a vertex that, when removed along with its associated edges, 
// increases the number of connected components in the graph. These vertices are critical for maintaining the connectivity of the graph.

// Input Format:
// ------------
// - The first line contains two integers V and E — the number of vertices and edges in the graph.
// - The next E lines contain two integers u and v — representing an undirected edge between vertex u and vertex v.
// Vertices are numbered from 0 to V - 1.

// Output Format:
// --------------
// - Print a list of articulation points in increasing order.
// - If there are no articulation points, print an empty list [].

// Constraints:
// -------------
// - 1≤ V ≤10^4
// - 0≤ E ≤10^5
// - No self-loops or multiple edges.

// Example Input 1:
// ----------------
// 5 5
// 1 0
// 0 2
// 2 1
// 0 3
// 3 4

// Example Output 1:
// ------------------
// [0, 3]

// Explanation: 
// -------------
// Removing vertex 0 disconnects 3 and 4 from the rest of the graph.  
// Removing 3 disconnects 4. So both are articulation points.

// Example Input 2:
// -----------------
// 4 3
// 0 1
// 1 2
// 2 3

// Example Output 2:
// -----------------
// [1, 2]

// Notes:
// -------
// - The graph may contain multiple components.
// - The result should be based on DFS traversal using Tarjan’s algorithm for finding articulation points efficiently.



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class articulationpoints {
    static int time = 0;

    public static List<Integer> findArticulationPoints(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V]; // Marks articulation points

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, isAP, adj);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }

        return result;
    }

    private static void dfs(int u, boolean[] visited, int[] disc, int[] low,
                            int[] parent, boolean[] isAP, List<List<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, visited, disc, low, parent, isAP, adj);
                low[u] = Math.min(low[u], low[v]);

                // Case 1: u is root and has 2+ children
                if (parent[u] == -1 && children > 1) {
                    isAP[u] = true;
                }

                // Case 2: u is not root and low[v] >= disc[u]
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Integer> articulationPoints = findArticulationPoints(V, adj);
        System.out.println(articulationPoints);
    }
}
