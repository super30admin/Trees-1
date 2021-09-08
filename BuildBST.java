// TIME: O(n)
// SPACE: O(n)
// SUCCESS on LeetCode

public class BuildBST {
    int index = 0;
    HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int root = preorder[index++];
        TreeNode node = new TreeNode(root);
        int sindex = inorderMap.get(root);
        node.left = helper(preorder, left, sindex - 1);
        node.right = helper(preorder, sindex + 1, right);
        return node;
    }
}
