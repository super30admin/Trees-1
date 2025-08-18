//approach-in a BST left<root && root<right. we are taking this property and doing a pre-order traversal (L-root-R)which should be in increasing order. we are passing the root value each time to the next call and comparing it to the current root and it should be less than the current nodes val. if no we return false.
//time complexity-O(n) as we are visiting each node once.
//space complexity=O(h) as we are not using any additional DS, the most we would have each time in the recursive stack the height of the tree, logn in balanced trees and n in skewed tree.
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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
      this.flag=true;
       helper(root,null);
       return flag;
    }

    private void helper(TreeNode root,Integer prev) {
        if (root == null)return;

        helper(root.left,prev);
          System.out.println(prev);
        if (prev != null && prev >= root.val)flag= false;
        prev = root.val;

      
        
       helper(root.right,prev);
        
    }
}
