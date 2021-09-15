// Time Complexity : O(n) 
// Space Complexity : O(h) where h is height of the tree (levels)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        //null check
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        
        while( root != null || !st.isEmpty() ) { //outer condition
            while( root != null ) { //inner check
                st.push(root); //pushing root inside stack first
                root = root.left; //moving the root ahead to left
            }
            root = st.pop(); //popping the top element because processed
            //catching it inside root so that we have track and use it
            
            if( pre != null && root.val <= pre.val ) return false; //fails the criteria of BST
            pre = root; //assigning current root to pre because moving ahead
            root = root.right; //moving ahead
        }
        return true; //if reaches here, it has to be BST
    }
}