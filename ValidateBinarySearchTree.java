//  Time Complexity: O(n)
//  Space Complexity: O(h) height of binary tree
class Solution {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean inorder(TreeNode root,long min,long max){
        if(root != null){
            if(root.val > min && root.val < max)
                return inorder(root.left, min, root.val) && inorder(root.right, root.val, max);
            else
                return false;
        }
        return true;
    }
}