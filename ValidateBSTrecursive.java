////Time Complexity :O(n)
//Space Complexity :O(1)
//Oracle Interview
//We will be doing both the approaches recursive one and the iterative one. in this problem we will make sure 3 three things whther all the values on left are smaller than the root value and all the values on the right are greater than the current value.

//Recursive Solution:
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
         return isValid(root, null, null);
}

    public boolean isValid(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}

