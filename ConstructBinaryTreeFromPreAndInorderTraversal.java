//TC: O(nlogn), for worst case-completely skewed tree-O(n^2)
//SC: O(logn) for balanced tree, O(n) worst case, skewed tree
//approach: get root from preorder, and search for it in inorder,
// left of root in inorder is left subtree, right is right subtree and so on

import java.util.Arrays;

public class ConstructBinaryTreeFromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int[] pleft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] pright = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left = buildTree(pleft, inleft);
        root.right = buildTree(pright, inright);
        return root;
    }
}
