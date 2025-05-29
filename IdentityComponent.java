// You are managing a social media platform with n users. Each user initially belongs to their own social group. 
// Over time, users form friendships, and each friendship connects two users into the same group. 
// Your task is to process a list of friendship connections, and then answer a series of queries asking whether two users are in the same 
// group.

// Friendships form before any queries are made. After all friendships are processed, for each query, 
// return whether the two queried users are in the same group.

// Input Format:
// -------------
// The first line contains an integer n — the number of users (0-indexed).

// The second line contains an integer c — the number of friendship connections.

// The next c lines each contain two integers a and b — indicating a friendship between user a and user b.

// The next line contains an integer q — the number of queries.

// The following q lines each contain two integers u and v — a query asking whether users u and v are in the same group.

// Output Format:
// ---------------
// For each query, print "Yes" if the two users are in the same group, otherwise print "No".

// Example Input:
// --------------
// 5
// 3
// 0 1
// 1 2
// 3 4
// 3
// 0 2
// 1 4
// 3 4

// Example Output:
// --------------
// Yes
// No
// Yes


// Constraints:
// -------------
// 1 <= n <= 10^5
// 0 <= a, b, u, v < n

// -Friendship connections are undirected
// -No self-loops in connections or queries
// -Efficient solution required (use DSU with path compression)

// Note:
// ----
// -Use Disjoint Set Union (Union-Find) to merge users into the same group during the connection phase.
// -Only use find() during query processing to check if two users belong to the same root (group).


import java.util.Scanner;
public class IdentityComponent{
    static class DSU{
        int[] parent;
        int[] rank;
        public DSU(int size){
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            } else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int c = sc.nextInt(); 
        DSU dsu = new DSU(n);
        for (int i = 0; i < c; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dsu.union(a, b);
        }
        int q = sc.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < q; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (dsu.find(u) == dsu.find(v)){
                output.append("Yes\n");
            } else{
                output.append("No\n");
            }
        }
        System.out.print(output);
        sc.close();
    }
}
