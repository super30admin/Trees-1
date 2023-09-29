/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Function to build a binary tree from preorder and inorder traversal arrays
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Check if either preorder or inorder arrays are empty, or both
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0)
            return null;

        // Get the value of the root node from the preorder array
        int rootVal = preorder[0];
        int rootId = -1; // Initialize the index of the root in the inorder array
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root value in the inorder array
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == rootVal) {
                rootId = i; // Store the index of the root value in the inorder array
                break;
            }
        }

        // Split the inorder and preorder arrays for left and right subtrees
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootId);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootId + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootId + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootId + 1, preorder.length);

        // Recur for left and right subtrees and set them as left and right children of the root
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root; // Return the root of the binary tree
    }
}

// Time Complexity: O(N^2) in the worst case, O(N) on average, where N is the number of nodes in the tree
// Space Complexity: O(N) in the worst case, O(logN) on average, where N is the number of nodes in the tree
