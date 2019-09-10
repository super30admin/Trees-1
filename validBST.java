//Time Complexity: O(N)
//Space Complexity:O(N)
//In this problem, I'll be using a helper function which will recursively check both the left and the right subtrees, whether they follow the property of BST, i.e, whether left node is less than the root and the right node is greater than the root. If found,will return true. Else, false.
//This code was executed successfully and got accepted in leetcode.


class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode node, long low,long high){
        if(node==null){
            return true;
        }
        int val=node.val;
        if(val <= low||val>=high){
            return false;
        }
        if(! helper(node.right,val,high)){
            return false;
        }
        if(! helper(node.left,low,val)){
            return false;
        }
        return true;
    }
}