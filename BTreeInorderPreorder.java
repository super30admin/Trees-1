//tc = O(n*n)
//sc = O(n*n)
//run successfully on leetcode
//no problems 

//Used the main method recursively and passed the perfect
//inorder and preorder pairs

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        int len = inorder.length;
        int Ind = 0;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                Ind = i;
                break;
            }
        }
        int[] InLeft = Arrays.copyOfRange(inorder, 0, Ind);
        int[] Inright = Arrays.copyOfRange(inorder, Ind + 1, len);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, Ind + 1);
        int[] preRight = Arrays.copyOfRange(preorder, Ind + 1, len);
        root.left = buildTree(preLeft, InLeft);
        root.right = buildTree(preRight, Inright);
        return root;

    }
}