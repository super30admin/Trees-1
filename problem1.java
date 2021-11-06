// 98 Validata BInary search tree
// soved on leetcode
// Time complexity-- O(n)
// scpace complexity -- O(n)

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
    TreeNode prev =null;
    public boolean isValidBST(TreeNode root) {
        
//         Stack <TreeNode> stack = new Stack();
//         TreeNode prev =null;
//         while(root!=null || !stack.isEmpty()){
                
//             while(root!=null){
//                 stack.push(root);
//                 root=root.left;
//             }
//             root=stack.pop();
//             if(prev!=null && prev.val>=root.val){
//                 return false;
//             }
//             prev=root;
//             root=root.right;
            
//         }
        return helper(root);
    }
    
    public boolean helper(TreeNode root){
        if(root==null){
            return true;
        }
        
        boolean leftSubTree = helper(root.left);
        if(prev!=null && prev.val>=root.val){
            return false;
        }
        
        prev=root;
        System.out.println(root.val);
        boolean rightSubTree = helper(root.right);
        
        return leftSubTree && rightSubTree;
        
    }
    
    
    
}