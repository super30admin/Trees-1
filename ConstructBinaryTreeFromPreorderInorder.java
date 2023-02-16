// TC: O(n)
// SC: O(n)

class Solution {
    int pInd = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int l, int r) {
        if(l > r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pInd]);
        pInd++;
        int loc = map.get(root.val);
        root.left = build(preorder, inorder, l, loc - 1);
        root.right = build(preorder, inorder, loc + 1, r);
        return root;
    }
}