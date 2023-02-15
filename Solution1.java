// Time Complexity : O(n)
// Space Complexity : O(h) where h = height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * At first I pass the root as well as null values for both minimum and maximum to the helper function. If the root is null, I return true. Else if minimum is not null and root.value is less
 * than minimum and maximum is not null and root.val is greater than max, I return false. I then recursively call the helper function on the left child with root.val as the max and right child
 * with root.val as the min
 */

class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }

    public boolean check(TreeNode root, Integer min, Integer max)
    {
        if(root==null)
        {
            return true;
        }
        if(min!=null && root.val<=min || max!=null && root.val>=max)
        {
            return false;
        }
      
        return check(root.left,min,root.val) && check(root.right,root.val,max);
    }
}