// Time Complexity : O(n) => As we are iterating over the n nodes
// Space Complexity : O(h) => Even though we don't use explicit stack we are
// using recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to check if min!= null && max != null

/*
 * Approach: This is the recursive way where we use min and max variables. At
 * each step we will check the range. For leftmost node the upper bound is set by it's parent value whereas for rightmost child the lowerbound is set by it's parent.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }
        
        return findValidity(root, null, null);
    }

    private boolean findValidity(TreeNode root, Integer min, Integer max){

        if(root == null){
            return true;
        }

        boolean case1 = findValidity(root.left, min, root.val);

        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }

        boolean case2 = findValidity(root.right, root.val, max);

        return case1 && case2;
    }
}