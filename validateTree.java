// TC - O(n)
//SC - O(h)   h: height of the tree
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
       // boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        
        if(root==null) return true;
        
        Stack<TreeNode> s = new Stack<>();
        
        while(root!=null || !s.isEmpty()){
            
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
     
    }
}