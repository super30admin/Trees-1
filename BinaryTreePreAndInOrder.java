// Approach
// Store each value's index from inorder in a HashMap for O(1) lookup.
// Use the next value in preorder as the root, then recursively construct the left and right subtrees using the inorder boundaries.
// Return the constructed root after processing all nodes.

// Time Complexity: O(n)
// Space Complexity: O(n) — HashMap + recursion stack.
import java.util.HashMap;
import java.util.Map;

public class BinaryTreePreAndInOrder {

    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderMap = new HashMap<>();

        // Store each value's index in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No nodes in this range
        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int rootIndex = inorderMap.get(rootValue);

        // Build left subtree
        root.left = build(preorder, left, rootIndex - 1);

        // Build right subtree
        root.right = build(preorder, rootIndex + 1, right);

        return root;
    }
}


