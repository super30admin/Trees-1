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
 */
class Solution {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a map to quickly find the index of any value in inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Recursively build the tree
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        // Base case
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        
        // The first element in preorder is the root
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root in inorder to determine the boundary of left and right subtrees
        int rootIndexInInorder = inorderIndexMap.get(rootValue);
        int leftSubtreeSize = rootIndexInInorder - inorderStart;
        
        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftSubtreeSize, inorderStart, rootIndexInInorder - 1);
        root.right = buildTreeHelper(preorder, preorderStart + leftSubtreeSize + 1, preorderEnd, rootIndexInInorder + 1, inorderEnd);
        
        return root;
    }
}
