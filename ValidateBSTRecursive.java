// Time Complexity : O(n) => As we are iterating over the n nodes
// Space Complexity : O(h) => Even though we don't use explicit stack we are using recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. When checking root == null in the recurse() changed the value of isValid to true due to which was getting incorrect ans

/*
Approach: This is the recursive way where we use a prev pointer along with the recurse() method of type void. Value of prev pointer is compared with the value of the next node, if it is greater then it indicates it is not a valid BST
 */
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        prev = null;
        isValid = true;

        recurse(root);
        return isValid;
    }

    private void recurse(TreeNode root){

        if(root == null){
            return;
        }

        recurse(root.left);

        if(prev != null && prev.val >= root.val){
            isValid = false;
            return;
        }

        prev = root;

        recurse(root.right);

    }
}