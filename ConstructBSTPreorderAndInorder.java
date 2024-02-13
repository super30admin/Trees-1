// Time complexity: O(n^2)
// Space complexity: Recursion stack O(h) where h = height of the tree (max recursion calls at one point)
// Approach: Traverse preorder array using global variable. Find it's position in inorder and recursively do the same
// for left and right subtrees

class ConstructBSTPreorderAndInorder {
    // traversing over preorder
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursive(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int left, int right) {
        // processed all elements or there's no left or right children
        if (index >= preorder.length || left > right) {
            return null;
        }

        TreeNode current = new TreeNode(preorder[index]);

        int position = -1;
        // finding index of root in inorder to figure out it's left and right subtrees
        for (int i = left; i <= right; i++) {
            if (inorder[i] == current.val) {
                position = i;
                break;
            }
        }

        // onto the next element in preorder
        index += 1;
        current.left = buildTreeRecursive(preorder, inorder, left, position - 1);
        current.right = buildTreeRecursive(preorder, inorder, position + 1, right);

        return current;
    }
}