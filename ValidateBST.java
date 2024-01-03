// Time Complexity : O(n)
// Space Complexity : O(n) Stack space
// Method Used : DFS

class Solution {

    long max_element = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root)
    {
        if(root == null) return true;

        if(inOrder(root.left) == false) return false;

        if(max_element < root.val) max_element = root.val;

        else return false;

        if(inOrder(root.right) == false) return false;

        return true;
    }
}