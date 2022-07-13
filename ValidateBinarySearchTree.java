/**
 * Time Complexity: O(N)
 * Space Complexity: O(h) - where h is the height of the Tree
 * */
public class ValidateBinarySearchTree {
    boolean isValid = true;
    TreeNode previousNode;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        if(previousNode != null && previousNode.val >= root.val){
            isValid = false;
        }
        previousNode = root;
        inorder(root.right);
    }
}