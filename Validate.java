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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)return true;
        
//         Stack<TreeNode> s = new Stack<>();
        
//         while(root != null || !s.isEmpty()){
//             while(root != null){
//                  s.push(root);
//                  root = root.left;
//             }
//         root = s.pop();
//         System.out.println(root.val);
//         root = root.right;
//         }
//     return false;
//     }
    
// }

//Time Complexity: O(n).
//Space Complexity: O(1).

class Solution {
    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        
        isValid = true;
        inorder(root);
    return isValid;
    
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        
        inorder(root.left);
        if(prev != null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}