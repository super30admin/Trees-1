// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer min, Integer max){
    	//empty tree is a valid BST
        if(root == null){
            return true;
        }
        //have boundary left and right for each node
        /*check If left node value is less than min and right node value is more than max then it 
        is out of boundary so return false*/
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        //update right boundary for right child and left boundary for left child
        return validate(root.right, root.val, max) && validate(root.left, min, root.val);
    }
}