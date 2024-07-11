//TC- O(N)
//TC- O(1)


class Solution {
    // Array to hold the preorder traversal
    int[] preorder;
    // Index to track the current root in preorder traversal
    int idx = 0;
    // HashMap to store the indices of inorder elements for quick access
    HashMap<Integer, Integer> inorderMap;

    // Method to build the binary tree from preorder and inorder traversals
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Initialize the HashMap
        this.inorderMap = new HashMap<>();
        // Populate the HashMap with inorder elements and their indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // Initialize the preorder array
        this.preorder = preorder;
        // Start the helper function to build the tree
        return helper(0, inorder.length - 1);
    }

    // Helper function to recursively build the tree
    private TreeNode helper(int leftIdx, int rightIdx) {
        // Base case: if the current subarray is invalid, return null
        if (leftIdx > rightIdx)
            return null;

        // Get the current root value from the preorder array
        int rootVal = preorder[idx];
        // Create the root node
        TreeNode root = new TreeNode(rootVal);
        // Move to the next root in the preorder array
        idx++;
        // Find the index of the current root in the inorder array
        int rootIdx = inorderMap.get(rootVal);

        // Recursively build the left subtree
        root.left = helper(leftIdx, rootIdx - 1);
        // Recursively build the right subtree
        root.right = helper(rootIdx + 1, rightIdx);

        // Return the root node
        return root;
    }
}

