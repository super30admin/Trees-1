// Time Complexity : O(n) as we go through all nodes
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, forgot to check
//  for lrange and rrange null condition before checking valid range or not


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    /** In this function our base case is that if we reached
     a null node it means that there was no case where binary
      search tree condition was invalid.
      For each node we check if it is within the valid range (i.e, if left node it
       should not be more than parent and if right node it should not be less than parent )
       We call the function recursively for both side nodes and return true only if both are true.
      **/
    public boolean helper(TreeNode node, Integer lrange, Integer rrange){
        if(node==null){
            return true;
        }

        if((lrange!=null && node.val<=lrange) || (rrange!=null && node.val>=rrange)){
            return false;
        }

        return helper(node.left, lrange, node.val) && helper(node.right, node.val, rrange) ;
    }
}