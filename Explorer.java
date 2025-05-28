// In a faraway galaxy, interstellar explorers have mapped N planets, numbered from 
// 0 to N-1, interconnected through space routes represented by the given 'routes'. 
// Each element routes[i] = [ai, bi] denotes a direct space route between planet 
// 'ai' and planet 'bi'.

// A Critical Gateway Planet  is a special 
// planet whose removal  increases the number of 
// disconnected Galactic Regions, thereby isolating groups of planets from each other.

// Given the number of planets (N), number of routes (M) and a list of direct space 
// routes (routes), identify and list all the Critical Gateway Planets within this galaxy.

// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of planets and routes
// Next M lines: Two space separated integers ai and bi.
 
// Output Format:
// --------------
// Print an integer, number of disconnected Galactic Regions.

// Example 1:
// ----------
// Input=
// 5 5
// 0 1
// 1 2
// 2 0
// 1 3
// 3 4

// Output=
// [1, 3]

// Explanation:
// Removing planet 1 disconnects the galaxy into two separate regions: {0,2} and {3,4}.
// Removing planet 3 isolates planet 4, increasing the number of Galactic Regions.


// Example 2:
// -----------
// Input=
// 4 3
// 0 1
// 1 2
// 2 3

// Output=
// [1, 2]

// Explanation:
// Removing planet 1 or 2 increases the Galactic Regions from 1 to 2.


// Constraints:
// - 1 <= n <= 2000
// - 1 <= routes.length <= 5000
// -  routes[i].length == 2
// - 0 <= ai <= bi < n
// - ai != bi
// - No repeated space routes exist (routes).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Explorer {
    static int time = 0;
    public static List<Integer> findArticulationPoints(int n, List<List<Integer>> graph) {
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        boolean[] ap = new boolean[n]; 
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int u = 0; u < n; u++) {
            if (!visited[u]) {
                dfs(u, visited, disc, low, parent, ap, graph);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ap[i]) result.add(i);
        }
        return result;
    }

    private static void dfs(int u, boolean[] visited, int[] disc, int[] low,
                            int[] parent, boolean[] ap, List<List<Integer>> graph) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, visited, disc, low, parent, ap, graph);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1)
                    ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;

            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        List<Integer> result = findArticulationPoints(n, graph);
        System.out.println(result);
    }
}
