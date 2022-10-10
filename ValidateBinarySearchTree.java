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
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// class Solution {
//     TreeNode prev;
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)
//             return true;
//         Stack<TreeNode> s = new Stack<>();
//         while(root != null || !s.isEmpty()){
//             while(root != null){
//                 s.push(root);
//                 root = root.left;
//             }
//             root = s.pop();
//             if(prev != null && prev.val >= root.val)
//                 return false;
//             prev = root;
//             root = root.right;
//         }
//         return true;
//     }
// }

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)
//             return true;
//         return checkValidity(root, null, null);
//     }
    
//     private boolean checkValidity(TreeNode root, Integer max, Integer min){
//         if(root == null)
//             return true;
        
//         if(max != null && root.val >= max)
//             return false;
//         if(min != null && root.val <= min)
//             return false;
        
//         boolean case1 = checkValidity(root.left, root.val, min);
//         boolean case2 = checkValidity(root.right, max, root.val);
        
//         return case1 && case2;
//     }
// }

class Solution {
    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        isValid = true;
        inorder(root);
        return isValid;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}

