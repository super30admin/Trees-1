import java.util.HashMap;

//Time Complexity: O(n)
//Space Complexity: O(n)


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
class ConstructBinaryTreeFromPreAndInOrders {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inOrderIndexMap = new HashMap();

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] preorder, HashMap<Integer, Integer> inOrderIndexMap, int rootIndex, int left,
                               int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);

        int mid = inOrderIndexMap.get(preorder[rootIndex]);

        if (mid > left) {
            root.left = splitTree(preorder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        }

        if (mid < right) {
            root.right = splitTree(preorder, inOrderIndexMap, rootIndex + mid - left + 1, mid + 1, right);

        }

        return root;
    }
}
