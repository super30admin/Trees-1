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


/**class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        while(root != null || !s.empty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
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
*/

 /** 
  * Problem 98
  * Iterative Approach
  * Time Complexity = O(N) 
  * Space Complexity = O(h)
  */

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root){
        prev = null;
        return inorder(root);
    }
    private boolean inorder(TreeNode root) {
        if(root == null){
            return true;
        }
        if(inorder(root.left) == false){
            return false;
        }
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        return inorder(root.right);
        
    }
}