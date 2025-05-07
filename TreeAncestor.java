import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TreeAncestor {
    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = (int) Math.ceil(Math.log(n) / Math.log(2));
        up = new int[n][LOG + 1];
        for (int i = 0; i < n; i++) Arrays.fill(up[i], -1);
        for (int i = 0; i < n; i++) up[i][0] = parent[i];
        for (int j = 1; j <= LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i <= LOG; i++) {
            if (((k >> i) & 1) == 1) {
                node = up[node][i];
                if (node == -1) return -1;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = sc.nextInt();
        TreeAncestor tree = new TreeAncestor(n, parent);
        int q = sc.nextInt();
        List<Integer> results = new ArrayList<>();
        
        for (int i = 0; i < q; i++) {
            int node = sc.nextInt();
            int k = sc.nextInt();
            results.add(tree.getKthAncestor(node, k));
        }
        
        for (int result : results) {
            System.out.println(result);
        }
    }
}
