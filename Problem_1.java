/*

Problem 1 https://leetcode.com/problems/validate-binary-search-tree/

TC : O(n)
SC : O(h)
Leet Code : Yes

*/

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        if (root == null){
            return true;
        }

        return inorder(root);
    }

    private boolean inorder(TreeNode root){

        if(root == null){
            return true;
        }

        boolean c1 = inorder(root.left);
        if(prev != null && prev.val >= root.val){
            return false;
        }

        prev = root;
        boolean c2 = inorder(root.right);

        return c1 && c2;
    }
}