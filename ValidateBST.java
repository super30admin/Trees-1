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
    TreeNode prev = null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        
        return inorder(root, null, null);
        // return flag;
    }

    // private void inorder(TreeNode root) {
    //     if(root == null) {
    //         return;
    //     }
    //     inorder(root.left);
    //     if(prev != null && prev.val >= root.val) {
    //         flag = false;
    //         return;
    //     }
    //     prev = root;

    //     System.out.println("Up");
    //     System.out.println(root.val);
    //     inorder(root.right);
    //     System.out.println("Down");
    //     System.out.println(root.val);
    // }

    private boolean inorder(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }

        
        if((min != null && root.val <= min) || (max != null && root.val >= max)) {
            flag = false;
            return false;
        }
        
        return inorder(root.left, min, root.val) && inorder(root.right, root.val, max);
    }
}
