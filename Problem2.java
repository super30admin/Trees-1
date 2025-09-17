// 105. Construct Binary Tree from Preorder and Inorder Traversal
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

/*
Ran on leetcode: Yes
TC: O(n) 
SC: O(n)
n is length of pre order or inorder array
preorder array gives the root node values and use the inorder array is used to determnine which nodes should be on left and right of the root.
*/

class Solution {
    private int rootPreorderIdx;
    private Map<Integer, Integer> inorderHashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.rootPreorderIdx = 0;
        // hashmap of inorder array key is val and value is index for search
        inorderHashMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderHashMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inorderStart, int inorderEnd){

        // if start and end cross each other 
        if(inorderStart > inorderEnd){
            return null;
        }

        // Get the root val from pre order array
        int rootVal = preorder[rootPreorderIdx];
        rootPreorderIdx++;
        // Create the node
        TreeNode root = new TreeNode(rootVal);

        // Build left subtree
        root.left = helper(preorder, inorderStart, inorderHashMap.get(rootVal) - 1);
        // Build right subtree
        root.right = helper(preorder, inorderHashMap.get(rootVal) + 1, inorderEnd);

        return root;
    }

}