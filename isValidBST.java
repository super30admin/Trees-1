// Time Complexity : O(n)
// Space Complexity :O(h) h-> height of the tree
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return isBST(null, root, null);            
    }
    
    private boolean isBST(Integer min, TreeNode root, Integer max){
        if(root==null) return true;
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        boolean case1= isBST(min, root.left, root.val);
        boolean case2= isBST(root.val, root.right, max);
        return case1 && case2;
    }
}