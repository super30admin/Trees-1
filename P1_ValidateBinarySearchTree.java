//TC O(n)
//SC O(1)

class Solution {
    Integer prev;
    public boolean inorder(TreeNode node) {
        if(node == null)    return true;
        boolean case1 = inorder(node.left);
        if(!case1) return false;
        if(prev!=null && node.val <= prev)   return false;
        prev = node.val;
        boolean case2 = inorder(node.right);
        return case1 && case2;
    }
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
}