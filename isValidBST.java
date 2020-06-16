// Time Complexity : O(n) where n is the number of the elements in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


//Iterative

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
    public boolean isValidBST(TreeNode root) {        
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode prev = null;
        while(root !=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null && root.val <= prev.val) return false;
            prev = root;
            root = root.right;
        }
        
        return true;
        
    }
}

// Recursive

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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
       return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        if(inorder(root.left) == false) return false;
        if(prev!=null && root.val <= prev.val) return false;
        prev = root;
        return inorder(root.right);
    }
}