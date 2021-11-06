// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
       return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean leftResult = inorder(root.left);
        if (leftResult == false) {
            return false;
        }
        
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        
        return inorder(root.right);
    }
}
