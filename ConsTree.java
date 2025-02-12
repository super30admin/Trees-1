/*
Time Complexity: O(N)
- We traverse each node once while constructing the tree.
- The hashmap lookup for inorder index takes O(1) time.
- Hence, the overall time complexity is O(N).

Space Complexity: O(N)
- O(N) for storing the inorder index map.
- O(H) for recursive stack space, where H is the height of the tree.
- In a balanced tree, H = O(log N), so space complexity is O(log N).
- In a skewed tree, H = O(N), so space complexity is O(N).
*/


import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    private Map<Integer, Integer> inorderIndexMap; // To store the index of each value in inorder array
    private int preorderIndex = 0; // Pointer for preorder traversal

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a hashmap to store inorder values and their indices for quick lookup
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // Recursively build the tree
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int left, int right) {
        // Base case: if left > right, no elements to construct the subtree
        if (left > right) return null;

        // Get the current root value from preorder
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of this root value in inorder traversal
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Recursively construct the left and right subtrees
        root.left = constructTree(preorder, left, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, right);

        return root;
    }
}

