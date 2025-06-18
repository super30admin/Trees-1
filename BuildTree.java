public class BuildTree {
    /* Approach - 1
     * Time and Space Complexity:
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), for storing the tree nodes in the recursion stack.
     * Approach:
     * 1. The first element of the preorder array is the root of the tree.
     * 2. Find the index of the root in the inorder array.
     * 3. Elements to the left of the root in the inorder array form the left subtree.
     * 4. Elements to the right of the root in the inorder array form the right subtree.
     * 5. Recursively build the left and right subtrees using the corresponding segments of the preorder and inorder arrays.
     * 6. Return the root of the constructed tree.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootIndx = -1;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndx = i;
            }
        }

        int inorderLeft[] = Arrays.copyOfRange(inorder, 0, rootIndx);
        int inorderRight[] = Arrays.copyOfRange(inorder, rootIndx + 1, inorder.length);

        int preorderLeft[] = Arrays.copyOfRange(preorder, 1, rootIndx + 1);
        int preorderRight[] = Arrays.copyOfRange(preorder, rootIndx + 1, preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }

    /* Approach - 2
     * Time and Space Complexity:
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), for storing the tree nodes in the recursion stack.
     * Approach:
     * 1. Use a HashMap to store the indices of elements in the inorder array for quick access.
     * 2. Recursively build the tree using preorder and inorder arrays.
     * 3. Maintain an index to track the current position in the preorder array.
     */
    
    int index;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[index++];
        
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal);

        root.left = build(preorder, inorder, start, rootIndex - 1);
        root.right = build(preorder, inorder, rootIndex + 1, end);

        return root;
    }

}
