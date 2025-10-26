
/**
 * LeetCode Problem: Validate Binary Search Tree
 * URL: https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * 
 * Solution Approach: Recursive DFS with min and max constraints. 
 * 
 */
public class ValidateBinaryTree {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }
    
       private boolean isValidBST(TreeNode root, Integer min, Integer max) {
           if(root == null) return true;
           if(min!= null && root.val <= min || max != null && root.val >= max) return false;
           return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
       }

       class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode() {}
           TreeNode(int val) { this.val = val; }
           TreeNode(int val, TreeNode left, TreeNode right) {
               this.val = val;
               this.left = left;
               this.right = right;
           }
       }

 
}