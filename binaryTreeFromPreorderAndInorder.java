/**
Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
TC: O(n)
SC: O(n)
*/
class Solution {
    int preOrderIndex = 0;
    HashMap<Integer, Integer> inorderIndexMap = null;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; ++i) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(root.val) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(root.val) + 1, right);
        return root;
    }
}