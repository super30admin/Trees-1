// Approach 2 : Min Max Approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean isValid = helper(root, null, null);
        return isValid;
    }
    
    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        
        //action
        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;
        
        //recurse
        boolean case1 = helper(root.left, min, root.val);
        boolean case2 = helper(root.right, root.val, max);
        
        return case1 && case2;
    }
}

//Time Complexity :O(n)
//Space Complexity :O(1)