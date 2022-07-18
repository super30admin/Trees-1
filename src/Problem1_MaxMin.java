//Time Complexity : O(n)
//Space Complexity : O(h), where h is the height of the tree.
//Code run successfully on LeetCode.

public class Problem1_MaxMin {
	
    public boolean isValidBST(TreeNode root) {
        
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        
        if(root == null)
            return true;
        
        if(min!= null && root.val <= min)
        {
            return false;
            
        }
        
        if(max!= null && root.val >= max)
        {
            return false;
        
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        
    }

}
