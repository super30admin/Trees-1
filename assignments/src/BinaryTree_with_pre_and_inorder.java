import java.util.HashMap;

public class BinaryTree_with_pre_and_inorder {

    // Time: O(n), Space: O(n)
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i<preorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, preorder.length-1);
    }

    TreeNode constructTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = constructTree(preorder, left, inorderMap.get(root.val)-1);
        root.right = constructTree(preorder, inorderMap.get(root.val)+1, right);

        return root;
    }
}