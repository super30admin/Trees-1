//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    int preorderIndex = 0;
   Map<Integer, Integer> Map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        for (int i = 0; i < inorder.length; i++) {
            Map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = Map.get(rootVal);
        root.left = build(preorder, inStart, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, inEnd);
        return root;
    }
}

