// 98. Validate Binary Search Tree - https://leetcode.com/problems/validate-binary-search-tree/
// Time Complexity - O(N), no. of nodes
// Space Complexity - O(H), height of tree
// Run on leetcode? - yes

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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()){
            // left
            while(root != null){
                stack.push(root);
                root=root.left;
            }
            // root
            root = stack.pop();
            // validating bst
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;
            
            // right
            root=root.right;
        }
        return true;
    }
}