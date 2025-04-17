// Time Complexity : O(n), where n is the number of nodes in the tree
//   - We visit each node exactly once during the in-order traversal
// Space Complexity : O(h), where h is the height of the tree
//   - This is due to the recursion stack. In the worst case (unbalanced tree), h = n; in the best case (balanced), h = log n

class Solution {

    TreeNode prev; // Tracks the previously visited node in in-order traversal

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root){
        if (root == null) return true;

        // Recursively validate the left subtree
        if (!helper(root.left)) return false;

        // Check current node value with the previous node's value
        if (prev != null && prev.val >= root.val) {
            return false;
        }

        // Update the previous node to current
        prev = root;

        // Recursively validate the right subtree
        return helper(root.right);
    }
}




// Time Complexity : O(n), where n is the number of nodes in the tree
//   - Each node is visited once
//   - HashMap lookup and insertions are O(1)
// Space Complexity : O(n)
//   - O(n) for the hashmap
//   - O(h) for recursion stack, where h is the height of the tree (O(n) in worst case, O(log n) for balanced)

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a value-to-index map for inorder traversal to access root positions in O(1)
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Build the tree using helper method
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        // Base case: if the inorder range is invalid, return null
        if (inStart > inEnd) return null;

        // Take current node value from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the root index in inorder to divide left and right subtrees
        int inIndex = inorderIndexMap.get(rootVal);

        // Recursively build the left subtree from inorder start to inIndex - 1
        root.left = build(preorder, inStart, inIndex - 1);

        // Recursively build the right subtree from inIndex + 1 to inorder end
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }
}
