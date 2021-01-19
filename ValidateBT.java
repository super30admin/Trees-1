//on leetcode only 53 / 75 test cases passed. I will update code once i find bug
class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return true;
        }

        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int value) {

        if(root == null) {
            return true;
        }

        if((root.left != null) && ((root.left.val >= value) || (root.left.val >= root.val))) {
            return false;
        }
        if((root.right != null) && ((root.right.val <= value) || (root.right.val <= root.val))) {
            return false;
        }
        return (helper(root.left, root.val) && helper(root.right, root.val) );
    }
}