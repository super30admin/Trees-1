// Time Complexity : O(n) where n is number of the node
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class solution
{
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer lb, Integer ub)
    {
        //base case
        if(root == null) return true;
        
        int val = root.val;
        if((lb!=null && val <= lb) || (ub!=null && val >= ub)) return false;
        
        return helper(root.left,lb,val) && helper(root.right,val,ub);
    }
}