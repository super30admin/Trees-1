import java.util.HashMap;
import java.util.Map;

// TC O(N)
// SC O(N)
public class ConstructTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        index++;
        int idx = map.get(rootVal);
        root.left = helper(preorder, start, idx - 1);
        root.right = helper(preorder, idx + 1, end);
        return root;
    }
}
