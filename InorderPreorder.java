import java.util.Arrays;
//time complexity: O(n); len of arrays
// sc : O(n); bcz of recursion stack
public class InorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int index = -1;

        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
