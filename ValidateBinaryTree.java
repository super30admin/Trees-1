import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class ValidateBinaryTree {
    //TC will be O(n)
    //SC will be O(n)
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        inorder(root);
        return true;
    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.val + "Up");
        inorder(root.right);
        System.out.println(root.val + "Down");
    }
}