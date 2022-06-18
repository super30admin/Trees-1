class Solution {
  
  //TC: O(n), sc: O(n)
    
    int rootIndex = 0;
       
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        int rootValue = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = helper(preorder, start, map.get(rootValue) - 1);
        root.right = helper(preorder, map.get(rootValue) + 1, end);
        
        return root;
    }
}
