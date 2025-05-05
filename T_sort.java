// given a graph(V) and N Edges print the Topolical Order of the Graph
// The first line of input contains the Number of Vertices followed by the Number of Edges and Edges between the Vertices 

// input = 
// 5 7
// 0 2
// 0 3
// 1 0
// 1 3
// 2 4
// 3 2
// 3 4
// output = 
// 1 0 3 2 4



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class T_sort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : graph.get(node)){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
       for (int node : topoOrder){
            System.out.print(node + " ");
        }
    }
}
      