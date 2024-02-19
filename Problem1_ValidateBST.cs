/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    TreeNode prev;
    public bool IsValidBST(TreeNode root) {
        return ValidateBST(root);
    }

    private bool ValidateBST(TreeNode root) {
        //base
        if(root == null) {
            return true;
        }

        //Left Traverse
        bool left = ValidateBST(root.left);

        //Logic to compare previous node's value with current node's value while traversing inorder.
        //As inorder traversal is always sorted. 
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root; // moving prev pointer to current node

        if(!left)
            return false;
        //Right Traversal
        bool right = ValidateBST(root.right);

        return left && right;
    }
}