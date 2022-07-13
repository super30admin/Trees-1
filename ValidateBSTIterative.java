//Time Complexity :O(n)
//Space Complexity :O(1)
//Oracle Interview

//We will be doing both the approaches recursive one and the iterative one. in this problem we will make sure 3 three things whther all the values on left are smaller than the root value and all the values on the right are greater than the current value.
//Iterative Solution:
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
        if (root == null) return true;
        Stack <TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val <= prev.val) return false;
            prev = root;
            root = root.right;
      }
       return true;
   }

}