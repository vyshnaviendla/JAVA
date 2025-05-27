import java.util.ArrayList;

public class ConnectedComponents {
    static void dfs(int currentNode, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[currentNode] = true;
        for (int neighbor : graph.get(currentNode)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        int numberOfNodes = 6;

        // Create graph with 6 nodes (0 to 5)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(3).add(4);
        graph.get(4).add(3);

        // Node 5 has no connections

        boolean[] visited = new boolean[numberOfNodes];
        int componentCount = 0;

        for (int i = 0; i < numberOfNodes; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                componentCount++;
            }
        }

        System.out.println("Number of connected components: " + componentCount);
    }
}
