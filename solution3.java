//lowest common ances 
//In a joint family, every person assigned with an ID, an integer value.
// and the entire family is arranged in the from of tree.

// You will be given the family tree and two persons IDs P1 and P2.
// Your task is to find the person ID, who is the latest common ascendant of P1 and P2.
// and return the Lowest Common Ascendant ID.

// Implement the class Solution:
//     - Node lowestCommonAscendant(Node root, Node P1, Node P2):
//         return the person ID who is the latest common ascendant of P1 and P2.


// Input Format:
// -------------
// Line-1: Single line of space separated integers, person ID's in the family.
// Line-2: Two Person IDs, P1 and P2.

// Output Format:
// --------------
// Return the latest common ascendant of P1 and P2.


// Sample Input-1:
// ---------------
// 3 5 1 6 2 0 8 -1 -1 7 4
// 6 4

// Sample Output-1:
// ----------------
// 5

// Sample Input-2:
// ---------------
// 11 99 88 77 22 33 66 55 10 20 30 40 50 60 44
// 66 55

// Sample Output-2:
// ----------------
// 11




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int val;
    Node left, right;
    Node(int val){
 this.val = val; 
 }
}
public class solution3{
    Node buildTree(List<Integer> list){
        if (list.isEmpty()) return null;
        Node root = new Node(list.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < list.size()){
            Node curr = q.poll();
            if (list.get(i) != -1) {
                curr.left = new Node(list.get(i));
                q.add(curr.left);
            }
            i++;
            if (i < list.size() && list.get(i) != -1){
                curr.right = new Node(list.get(i));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    Node find(Node root, int val){
        if (root == null || root.val == val) return root;
        Node left = find(root.left, val);
        return (left != null) ? left : find(root.right, val);
        }
    Node lca(Node root, Node a, Node b){
        if (root == null || root == a || root == b) return root;
        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> nodes = new ArrayList<>();
        for (String s : sc.nextLine().split(" "))
            nodes.add(Integer.parseInt(s));
        int a = sc.nextInt();
        int b = sc.nextInt();
        solution3 sol = new solution3();
        Node root = sol.buildTree(nodes);
        Node n1 = sol.find(root, a);
        Node n2 = sol.find(root, b);
        System.out.println(sol.lca(root, n1, n2).val);
    }
}