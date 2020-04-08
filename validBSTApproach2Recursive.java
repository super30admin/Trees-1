//time - O(n)
//space - O(h) -> h - height of tree
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, null, null);    
    }
    
    private boolean isValidBSTUtil(TreeNode root, Integer minValue, Integer maxValue)
    {
        //here each node has seperate min and max so use parameters in recursion
        //base
        if(root == null)
        {
            return true;
        }
        if((maxValue != null && root.val >= maxValue) || (minValue != null && root.val <= minValue))
        {
            return false;
        }
        //logic
        return(isValidBSTUtil(root.left, minValue, root.val) && isValidBSTUtil(root.right, root.val, maxValue));
    }
}
