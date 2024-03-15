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

//TC: O(n)
//SC: O(n)
public class validateBST {
    // TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        // inorder(root);
        helper(root, null, null);
        return flag;
    }
    private void helper(TreeNode root, Integer min, Integer max){
        //base
        if (root==null) return;
        //for min
        if (min!=null && root.val<=min){
            flag = false;
        }
        //for max
        if (max!=null && root.val>=max){
            flag = false;
        }
        //logic
        //left
        helper(root.left, min, root.val);
        //right
        if(flag){
            helper(root.right, root.val, max);
        }
    }
    /** private void inorder(TreeNode root){
     ///base case

     if(root==null || !flag) return;

     inorder(root.left);
     if(prev!=null && prev.val>=root.val){
     flag = false;
     }
     // System.out.println(root.val);
     prev = root;
     // if(flag)
     inorder(root.right);  **/
}
