/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode lef   t, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;  // To keep track of the previously visited node during inorder traversal
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        
        Stack<TreeNode> s = new Stack<>();  // Stack to perform iterative inorder traversal

        // Perform iterative inorder traversal
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;  // Traverse to the leftmost node
            }
            root = s.pop();  // Process the node at the top of the stack
            if (prev != null && prev.val >= root.val)
                return false;  // Check if the nodes are in the correct order
            
            prev = root;  // Update the previously visited node
            root = root.right;  // Traverse to the right child
        }
        return true;  // The tree is a valid binary search tree
    }
}

// Time Complexity: O(N) - We traverse each node once, where N is the number of nodes in the tree.
// Space Complexity: O(h) - The space used by the stack is at most the height of the tree (h), due to the recursive nature of the inorder traversal.
