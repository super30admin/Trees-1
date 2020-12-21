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
//TC: O(N)
//SC: O(N)
//Iterative Approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        //Stack aproach
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        //If root present and Stack is not empty
        while(root != null || !s.isEmpty()){
            while(root != null){
                //push root node in stack
                s.push(root);
                // iterate to left
                root = root.left;
            }
            //after the iteration just pop the element
            root = s.pop();
            
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}