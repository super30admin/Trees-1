// Time Complexity : O(n) where n is number of node in the binary tree
// Space Complexity : O(h) where h is height of binary tree. in worst case the height of binary tree can be n, so space can be O(n) in that case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class ValidateBST{
    public static void main(String[] args) {
        
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
            
        }
        TreeNode(int val) { 
            this.val = val; 
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}