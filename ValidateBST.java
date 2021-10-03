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
    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        isValid = true;
        // return inorder(root);
    
       Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root!=null){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            //Compare root val with prev val
            if(prev!=null && prev.val >= root.val){
                isValid = false;
                break;
            }
            prev = root;
            root = root.right;
        }
        return isValid;
    }
}
