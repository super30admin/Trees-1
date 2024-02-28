import java.util.HashMap;
import java.util.Map;

class TreeNode {
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

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Build a Map of Inorder Traversal for faster lookup of array element indices
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderMap, int rootIdx, int left, int right) {

        // First element in the pre-order traversal will be the root
        TreeNode root = new TreeNode(preorder[rootIdx]);

        int mid = inOrderMap.get(preorder[rootIdx]);

        if (mid > left) {
            root.left = splitTree(preorder, inOrderMap, rootIdx + 1, left, mid - 1);
        }

        if (mid < right) {
            root.right = splitTree(preorder, inOrderMap, rootIdx + mid - left + 1, mid + 1, right);
        }

        return root;
    }
}
