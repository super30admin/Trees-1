// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//98. Validate Binary Search Tree (Medium) - https://leetcode.com/problems/validate-binary-search-tree/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max) {
    	// Time Complexity : O(n), Space Complexity : O(1)
//    	Stack<TreeNode> stack = new Stack<>();
//        TreeNode prev = null;
//        
//        while (root != null || !stack.isEmpty()) {
//            // inorder(root.left)
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            
//            root = stack.pop();
//            if (prev != null && prev.val >= root.val) {
//                return false;
//            }
//            
//            prev = root;
//            root = root.right;
//        }
//        
//        return true;
        // base
        if (root == null) return true;
        
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }
        // logic
//         boolean left = helper(root.left, min, root.val);
        
//         boolean right = true;
        
//         if (left) {
//             right = helper(root.right, root.val, max);
//         }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}