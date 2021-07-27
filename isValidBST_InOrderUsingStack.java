// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
        
        //Approach is to implement stack to do Inorder traverse
        //Validating if its a valid BST
        
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while (root != null || !stack.isEmpty()){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            //validating bst
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;
            System.out.println(root.val);
            root = root.right;
            
        }
        return false;
        
    }
}
