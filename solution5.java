import java.util.Scanner;

public class solution5 {
    public TreeNode lowestcommonancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = lowestcommonancestor(root.left, p, q);
        TreeNode right = lowestcommonancestor(root.right, p, q);
        if (root == p || root == q) return root;
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public boolean exists(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root == target) return true;
        return exists(root.left, target) || exists(root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!exists(root, p) || !exists(root, q)) return null;
        return lowestCommonAncestor(root, p, q);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) nodes[i] = new TreeNode(sc.nextInt());
        for (int i = 1; i < n; i++) {
            int parentIndex = sc.nextInt();
            if (parentIndex != -1) {
                if (nodes[parentIndex].left == null) nodes[parentIndex].left = nodes[i];
                else nodes[parentIndex].right = nodes[i];
            }
        }
        TreeNode p = nodes[sc.nextInt()];
        TreeNode q = nodes[sc.nextInt()];
        solution5 sol = new solution5();
        TreeNode lca = sol.lowestCommonAncestor(nodes[0], p, q);
        if (lca != null) System.out.println(lca.val);
        else System.out.println("null");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
