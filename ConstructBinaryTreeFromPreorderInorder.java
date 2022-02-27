/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 TC - O(n) where n is the length of preorder array + O(1) = O(n)
 SC - O(n) where n is the size of HashMap.
 */
class Solution {
    
    private Map<Integer, Integer> valueToIndex = new HashMap<>();
    private int preorderIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preorderIndex = 0;
        
        for (int i=0; i<inorder.length; i++)
        {
            valueToIndex.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int preorder[], int inorder[], int left, int right)
    {
        if (left > right)
        {
            return null;
        }
        
        int val = preorder[preorderIndex];
        int index = valueToIndex.get(val);
        preorderIndex++;
        
        TreeNode root = new TreeNode(val);
        root.left = buildTreeHelper(preorder, inorder, left, index - 1);
        root.right = buildTreeHelper(preorder, inorder, index + 1, right);
        
        return root;
    }
}
