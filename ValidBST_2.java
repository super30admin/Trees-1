/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(prev != null && root.val <= prev.val)
                return false;
            
            
            prev = root;
            root = root.right;
        }
        
        return true;
    }
}