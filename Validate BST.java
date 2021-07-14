//Time Complexity : O(n). n is the number of nodes in the tree
//Space Complexity : O(h), where h is the height of the tree. in the worst case,
// .i.e if the tree is left skweed,then the total number of node is equal
// to the height of the tree hence O(h).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    TreeNode prev;
    boolean res;
    public void checkBST(TreeNode root){
        if(root==null){
            return;
        }
        checkBST(root.left);
        if(prev!=null && prev.val >= root.val){
            res = false;
            return;
        }
        prev = root;
        checkBST(root.right);
       
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        prev = null;
        res = true;
        checkBST(root);
        return res;
    }
}