// We know that first element of preorder will be our root and then locating the position of root in inorder, then dividing recursively
// the inorder array and preorder array to construct the left and right subtrees. Elements to the left of root will be in left subtree
// and vice versa. So, then again the root of left subtree will be the next element in preorder array, so repeat same steps.

// Time Complexity : O(H^2)
// Space Complexity : O(H^2) - Recursive stack space and creating 4 arrays for each node
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case
        if (preorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // First value in preorder is the root of the tree
        int rootVal = preorder[0];
        // Create a root node
        TreeNode root = new TreeNode(rootVal);
        // Initialize the index of rootnode in inorder to be -1
        int rootIdx = -1;
        // Iterate through inorder array and find out the position of root node
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        // Create the left and right subtree preorder and inorder arrays with the help
        // of position of root
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        int[] inrderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inrderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        // Recursively call the function for creating the left and right subtrees
        root.left = buildTree(preorderLeft, inrderLeft);
        root.right = buildTree(preorderRight, inrderRight);
        // Return root
        return root;

    }
}