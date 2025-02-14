// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

public class ConstructTreePreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }

    private TreeNode helper(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inright = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preleft = Arrays.copyOfRange(preorder, 1, 1+inleft.length);
        int[] preright = Arrays.copyOfRange(preorder, 1+inleft.length, preorder.length);

        root.left = helper(preleft, inleft);
        root.right = helper(preright, inright);
        return root;
    }
}
