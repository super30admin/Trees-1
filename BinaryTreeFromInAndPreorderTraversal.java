import java.util.HashMap;

public class BinaryTreeFromInAndPreorderTraversal {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        //base case
        if (start > end)
            return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        //left subtree
        root.left = helper(preorder, start, rootIdx - 1);

        //right subtree
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }
}

//TC: O(n), SC: O(n)
