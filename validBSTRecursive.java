//time - O(n)
//space - O(h) - h -> height of tree
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    
    public boolean inOrder(TreeNode root) {
        //base
        if(root == null)
        {
            return true;
        }
        //logic
        if(isValidBST(root.left) == false)
        {
            return false;
        }
        if(prev != null && prev.val >= root.val)
        {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }
}
