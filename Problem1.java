class Solution {
    int idx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(preorder, 0, preorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int start, int end) {

        if (start > end)
            return null;

        int rootval = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootval);
        int rootidx = map.get(rootval);
        root.left = recur(preorder, start, rootidx - 1);
        root.right = recur(preorder, rootidx + 1, end);
        return root;
    }
}