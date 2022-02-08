import java.util.*;

class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;

        while (root != null || !s.isEmpty()) {
            // Left
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            // Node
            root = s.pop();
            System.out.println(root.val);

            // Compare root and prev for the num to grow (10, 25, 30, 50, 60, 70, 80)
            if (prev.val >= root.val && prev != null) {
                return false;
            }
            // Right
            prev = root;
            root = root.right;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
// O(n)
// O(n)
// Inorder traversal is always sorted array.