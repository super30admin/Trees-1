/*
 * Time and Space Complexity:
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree due to recursion stack.
 * Approach:
 * 1. Perform an in-order traversal of the tree.
 * 2. During the traversal, check if the current node's value is greater than the previous node's value.
 * 3. If any node violates the BST property, set a flag to false.
 * 4. Return the flag after the traversal.  
 */
public class ValidBST {
    boolean isValildBST;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValildBST;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            isValildBST = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}