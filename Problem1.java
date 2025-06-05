//98 : Validate BST
//solved on leetcode n faces no issues
//tc : O(n) sc:O(1)

class Solution {
    public boolean isValidBST(TreeNode root) {
        return checking(root , Long.MIN_VALUE , Long.MAX_VALUE);

        
    }
    public boolean checking(TreeNode root , long min , long max){
        if(root == null ){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        boolean left = checking(root.left , min , root.val);
        boolean right = checking(root.right , root.val , max);
        return left && right;
    }
}