/**
 * Time Complexity - O(n) - n = nodes in tree;
 * Space Complexity - O(n) - n = nodes in tree
 *
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    int inorder_index=0;
    int preorder_index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(inorder,preorder, Integer.MIN_VALUE);

    }



    private TreeNode helper(int[] inorder, int[] preorder, int rootValue){

        if(this.preorder_index >= preorder.length){
            return null;
        }

        if(inorder[this.inorder_index] == rootValue){
            this.inorder_index++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[this.preorder_index++]);
        root.left= helper(inorder,preorder,root.val);
        root.right= helper(inorder,preorder,rootValue);
        return root;
    }
}