

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class ValidateBST {

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

    public boolean isValidBST(TreeNode root) {

        boolean isValid = false;
        if(root == null){
            return true;
        }
        return checkIfBST(root,Long.MIN_VALUE ,Long.MAX_VALUE);
    }

    public boolean checkIfBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return checkIfBST(root.left, min, root.val) && checkIfBST(root.right, root.val, max);
    }
}
