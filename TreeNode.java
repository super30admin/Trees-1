
//Definition for a binary tree node.
// Time Complexity : O(n)
// Space Complexity : O(n) -> recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TreeNode {
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
 
class Solution {
    boolean isValid; // global variable
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
   
        isValid = true;
        findValidity(root, null, null); // setting them to null as in the problem we have 2^-31 as min and 2^31 as max
        return isValid;  
    }

    private void findValidity(TreeNode root, Integer min, Integer max){
        if(root == null){
            return; // base case
        }
        findValidity(root.left, min, root.val); // traversing till left end of tree
        if( ( min != null && root.val <= min ) || ( max != null && root.val >= max)){ // check to see if it is in ascending order as we are doing inorder traversal
            isValid = false;
            return;
        }
   
        findValidity(root.right, root.val, max); // traversing till right end
    }
} 