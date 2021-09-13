package Trees1;
// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree(recursion stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import Trees1.TreeNode;

// Your code here along with comments explaining your approach
public class ValidateBST1 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        if(min != null)
            if(root.val <= min)
                return false;
        if(max != null)
            if (root.val >= max)
                return false;
        boolean ans1 = helper(root.left, min, root.val);
        boolean ans2 = helper(root.right, root.val, max);
        return (ans1 && ans2);
    }
}
