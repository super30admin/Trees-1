// Time Complexity : O(N), N is the max number of elements in the tree
// Space Complexity : O(H) where H is the height of the tree. This will be the max amount of space used in the stack.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        // base case
        if (root == null) return true;

        return checkValidity(root, null, null);

    }

    private boolean checkValidity(TreeNode root, Integer max, Integer min) {
        // base
        if (root == null) return true;
        // logic
        if(max != null && root.val >= max) return false;
        if (min != null && root.val <= min) return false;
        boolean case1 = checkValidity(root.left, root.val, min);
        boolean case2= checkValidity(root.right, max, root.val);

        return case1&&case2;
    }
//     public boolean isValidBST(TreeNode root) {
//         // base case
//         if (root == null) return isValid;

//         isValid = true;
//         Stack<TreeNode> s = new Stack<>();
//         while(root!=null || !s.isEmpty()) {
//             while(root != null) {
//                 s.push(root);
//                 root = root.left;
//             }
//             root = s.pop();
//             if (prev!=null && prev.val >= root.val) {
//                 return false;
//             }
//             prev = root;
//             System.out.println(root.val);
//             root = root.right;
//         }
//         return true;
//     }

//     private void inOrderTraversal(TreeNode root) {
//         // base case
//         if (root == null) return;

//         // Left sub-tree
//         if (isValid) inOrderTraversal(root.left);
//         if (prev !=null && prev.val >= root.val) {
//             isValid = false;
//             return;
//         }
//         prev = root;
//         // Right sub-tree
//         if (isValid) inOrderTraversal(root.right);
//     }
}