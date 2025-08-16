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
 // This solution uses the approach of updating the previous value whenever a node is traversed in the tree. 
class Solution {

    // Global flag to check if any of the anomaly occured i.e., prev>=existing node val
    boolean check = true;

    // Prev starts with null
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        checkBST(root);
        return check;
    }

    private void checkBST(TreeNode root) {
        if(root==null) return;
      
        if(!check)return;
        // Traverse left node and do not update the prev val yet
        checkBST(root.left);
        if(prev!=null && prev >= root.val) {
            check=false;
            return;
        }

        if(!check)return;
        prev=root.val;
        // Traverse left node with the updated prev val with the existing node
        checkBST(root.right);
    }
}
