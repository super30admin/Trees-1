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
 /**
 This Java solution constructs a binary tree from preorder and inorder traversal arrays using a recursive approach:
The buildTree function initializes the process and calls the recursive helper function with appropriate parameters.
The helper function creates the root node from the current preorder value, finds its index in inorder array to determine left and right subtrees, and recursively builds the left and right subtrees.
The process continues until the preidx reaches the end of the preorder array or the left index surpasses the right index.
Time Complexity: O(N) - where N is the number of nodes in the binary tree, as each node is processed once.
Space Complexity: O(H) - where H is the height of the binary tree. The space used by the recursive call stack is proportional to the height of the tree. 
In the worst case, the height is O(N), making the space complexity O(N).


  */
  class Solution {
    private int preidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1);
        
        
    }
    private TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(preidx == preorder.length || left>right) return null;
        TreeNode root = new TreeNode(preorder[preidx]);
        for(int i=left;i<=right;i++){
            if(preorder[preidx] == inorder[i]){
                preidx++;
                root.left = helper(preorder, inorder, left, i-1);
                root.right = helper(preorder, inorder,  i+1, right);
                break;
            }

        }
        return root;
    }
}