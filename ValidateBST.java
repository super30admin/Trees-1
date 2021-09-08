// TIME: O(n)
// SPACE: O(n)
// SUCCESS on LeetCode

public class ValidateBST {
    boolean answer;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        answer = true;
        inorder(root, null);
        return answer;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null && prev.val >= node.val) {
            answer = false;
        }
        prev = node;
        inorder(node.right);
    }
}
