import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    private List<Integer> bst;
    
    
    public boolean isValidBST(TreeNode root) {
        
        bst = new ArrayList<>();
        
        validateBST(root);
        
        for (int i = 1; i < bst.size(); i++) {
            if (bst.get(i) <= bst.get(i-1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void validateBST(TreeNode node) {
        
        // base
        if (node == null) {
            return;
        }
        
        // left
        validateBST(node.left);
        
        // node
        bst.add(node.val);
        
        // right
        validateBST(node.right);
    }
}

