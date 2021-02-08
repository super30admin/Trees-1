// Time Complexity : O(V+E)
// Space Complexity : O(d) depth of tree 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// DO a inorder traversal of tree where current node should be greater than previos node
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        Integer prev = null;
        Stack<TreeNode> s = new Stack();
        
        while(root!=null || !s.isEmpty()) {
            
            while(root!=null) {   
                s.add(root);
                root=root.left;
            }
        
        
            root = s.pop();
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;

            root = root.right;
        }
        
        return true;
    }
}
