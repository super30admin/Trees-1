// Time Complexity : O(height)
// Space Complexity : O(nodes) for hashmap + O(height) Stack space

class Solution {
	
    HashMap<Integer, Integer> inorderMap;
    int preorderIndex;
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 || inorder.length == 0) return null;
        
        inorderMap = new HashMap();
		
        for(int i = 0;i < inorder.length;i++) inorderMap.put(inorder[i], i);
        
        return helper(0, inorder.length - 1, preorder);
    }
    private TreeNode helper(int left, int right, int[] preorder)
    {
        if(left > right) return null;
        
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = helper(left, inorderMap.get(root.val) - 1, preorder);
        root.right = helper(inorderMap.get(root.val) + 1, right, preorder);
        
        return root;
    }
}