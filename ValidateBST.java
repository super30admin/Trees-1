
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class ValidateBST {
    // Recurrsion solution (TC: O(n) SC: O(1))
    boolean result;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        result = true;
        inOrder(root);
        return result;

    }

    private void inOrder(TreeNode root) {
        // base
        if (root == null)
            return;
        inOrder(root.left);
        if (prev != null && prev.val >= root.val)
            result = false;
        prev = root;
        inOrder(root.right);

    }
}

// Iterative solution (TC: O(n) SC:O(n))
// public boolean isValidBST(TreeNode root) {
// Stack<TreeNode> st = new Stack<>();
// TreeNode prev = null;
// while(root != null || !st.isEmpty()){
// while(root != null){
// st.push(root);
// root = root.left;
// }
// root = st.pop();
// //compare with prev Node
// if(prev != null && prev.val >= root.val) return false;
// prev = root;
// root = root.right;
// }
// return true;

// }