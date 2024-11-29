/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Problem1 {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    public void inorder(TreeNode root){
        // null check
        if(root == null) return;
        // left the root in the stack and go to the child.
        inorder(root.left);
        //stack.pop() happens

        // Checking whether prev is smaller than root or not
        if(prev != null && prev.val>=root.val){
            // this condition will mean that if left child > root
            // or parent of right child > right child we should stop.
            flag = false;
            return;
        }
        prev = root;    // needed just before traversing right subtree

        inorder(root.right);

    }
}