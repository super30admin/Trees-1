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

//Time Complexity:O(N)
//Space Complexity:O(1)

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        boolean isValid=true;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prev!=null && prev.val>=root.val){
                isValid=false;
                break;
            }
            prev=root;
            root=root.right;
        }
        return isValid;
    }
}