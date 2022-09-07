// Approach: We are basically doing an inorder traversal and compare prev with root to check if they are maintaining the order
// where prev should be less than root's value. So we can use inorder to check if the tree is sorted

// Time complexity: O(n)
// Space complexity: O(h) where h is the height of the tree 

// Iterative approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // add all left elements to the stack
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}