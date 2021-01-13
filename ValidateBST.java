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
/*
time complexity :O(n), is worst case 
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        //method 1 - use stack to put all left subtree and compare each element with the parent of it
        //.        - then put all right subtree and compare each element with the parent of it
        
        
        if(root == null){
            return false;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                //go on adding all the left elements
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            while(prev != null && root.val <= prev.val){
                return false;
                
            }
            
            prev = root;
            root = root.right;
        }
        return true;
    }
    
}
