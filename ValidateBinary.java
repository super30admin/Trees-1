//o(n) time and constant space
//passed all leetcode cases
//used approach discussed in class
class Solution {
    public boolean isValidBST(TreeNode root) {
        //return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return helper(root, null, null);

    }
    private boolean helper(TreeNode root, Integer max, Integer min){
        if(root==null) return true;
        if((max!=null && root.val>=max)||(min!=null && root.val<=min)) return false;
        return helper(root.left,root.val,min)&&helper(root.right,max,root.val);
    }
}