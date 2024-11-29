// Time Complexity :O(n) n=number of nodes in given tree
// Space Complexity :O(n) n=maximum depth of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        
        if(root == null){
            return true;
        }
        
        TreeNode previous = null;
        TreeNode current = null;
        Stack<TreeNode> bst = new Stack<>();
        
        while(!bst.isEmpty() || root != null){
            while(root != null){
                bst.add(root);
                root=root.left;
            }
            
            current = bst.pop();
            if(previous != null && previous.val>=current.val){
                return false;
            }
            previous=current;
            
            root=current.right;
        }
        
        return true;
    }
}