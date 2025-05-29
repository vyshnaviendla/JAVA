// A company has n offices, each initially isolated. A list of m proposed network cables between pairs of offices is provided. 
// Your task is to determine the minimum number of cables needed to connect all offices together (i.e., make the network fully connected).

// Each cable connects two distinct offices. Implement a function that returns the number of cables used to form the 
// full connection or -1 if it's impossible.

// Input Format:
// -------------
// The first line contains two integers: n and m
// The next m lines each contain two integers a and b — representing a cable between office a and office b

// Output Format:
// ---------------
// A single integer: number of cables used to connect all offices, or -1 if not possible

// Example:

// Input:
// -----
// 4 3
// 0 1
// 1 2
// 2 3

// Output:
// --------
// 3


// Explanation:
// -------------
// n = 4 offices: {0, 1, 2, 3}
// m = 3 cables

// Cables: (0-1), (1-2), (2-3)

// These cables can fully connect all 4 offices (via successful 3 unions)

// Hence, Output = 3


import java.util.Scanner;

public class NetworkConnection{

    static class DSU {
        int[] parent;
        int[] rank;
        int components;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false;

            // Union by rank
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            components--;
            return true;
        }

        public int getComponents() {
            return components;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of offices
        int m = sc.nextInt(); // Number of cables

        DSU dsu = new DSU(n);

        int usedCables = 0;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (dsu.union(a, b)) {
                usedCables++;
            }
        }

        // If all offices are connected, components must be 1
        if (dsu.getComponents() == 1) {
            System.out.println(usedCables);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}
