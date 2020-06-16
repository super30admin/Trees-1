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
class Solution {
    
        // Time Complexity : O(No. of treenodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.Iterative inorder approach using prev variable to compare the current root with previous root
*/
    
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while((root != null) || !(st.empty())){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!= null && root!=null && prev.val>=root.val) return false;
            prev = root;
            root = root.right;
            if(prev!=null && root!=null && prev.val>=root.val) return false; 
        }
        return true;
        
    }
}




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
class Solution {
    
    // Time Complexity : O(No. of treenodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.Recursive inorder approach using prev variable to compare the current root with previous root
*/
    
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
           return inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        //base
        if(root == null) return true;
        
        //logic
        if(!inOrder(root.left)) return false;
        if(prev!=null && prev.val>=root.val) return false;
        prev = root;
        return inOrder(root.right);
    }
}