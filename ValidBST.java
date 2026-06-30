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
class Solution {
    //TC - O(n)
    //SC - O(h)
    /*
        Inthis solition we are using inorder traversal to validate the BST. The previously visited node
        is saved in the prev variable and the current node's value is compared to the previously visited node.
        If current value is less or equal to the prev node's value then it is not a valid BST and set the value of flag to
        false. We use flag to keep track of this and when flag is false, we break out of the tree traversal.
    */
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        isValid(root);
        return flag;
    }

    private void isValid(TreeNode root) {
        if (root == null) return;
        if (!flag) return;

        isValid(root.left);

        if (prev != null && root.val <= prev.val) {
            flag = false;
        }

        prev = root;

        isValid(root.right);
    }
}