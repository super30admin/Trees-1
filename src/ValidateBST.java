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

// Inorder traversal of a tree should be in asceding order
class ValidateBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    public void helper(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        helper(root.left);
        if(prev!=null && root.val <= prev.val) {
            flag = false;
        }
        prev = root;
        if(flag) {
            helper(root.right);
        }
    }
}


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

//Check if the value at a particular node lies within the range of values
class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root,null,null);
        return flag;
    }

    public void helper(TreeNode root, Integer low, Integer high) {
        if(root == null) return;
        // check whether the value at a particular node lies within the range
        if((low!=null && root.val<= low) || (high!=null && root.val>= high)) {
            flag = false;
        }
        if(flag) {
            helper(root.left, low, root.val);
            helper(root.right, root.val,high);
        }
    }
}
