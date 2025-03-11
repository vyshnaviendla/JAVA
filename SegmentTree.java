import java.util.Scanner;

public class SegmentTree {
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    // Builds the segment tree recursively
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    // Updates the segment tree at index 'i' with value 'val'
    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    // Returns the sum of elements in range [start, end]
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start > mid) {
            return sumRange(root.right, start, end);
        } else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        SegmentTree st = new SegmentTree(nums);
        while (q-- > 0) {
            int opt = scan.nextInt();
            if (opt == 1) {
                int s1 = scan.nextInt();
                int s2 = scan.nextInt();
                System.out.println(st.sumRange(s1, s2));
            } else if (opt == 2) {
                int ind = scan.nextInt();
                int val = scan.nextInt();
                st.update(ind, val);
            }
        }
        scan.close();
    }
}
