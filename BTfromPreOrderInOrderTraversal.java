TC: O(N)
SC: O(H) // height of the stack


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
class BTfromPreOrderInOrderTraversal {
    int i = 0, p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return building(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode building(int[] preorder, int[] inorder, int stopValue) {

        if (p >= preorder.length) return null;

        if (inorder[i] == stopValue) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = building(preorder, inorder, node.val);
        node.right = building(preorder, inorder, stopValue);

        return node;
    }
}