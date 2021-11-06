// 105 Construct Binary Tree from Preorder and inforder Traversal
// Sovled on leetcode 
// Time Complexity - O(n^2)
// space complexity -- O(n^2)

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int inorderIndex=0;
        
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                inorderIndex=i;
                break;
            }
        }
        int [] preorderLeftSubTree = Arrays.copyOfRange(preorder,1,inorderIndex+1);
        int [] inorderLeftSubTree = Arrays.copyOfRange(inorder,0,inorderIndex);
        
        int [] preorderRightSubTree = Arrays.copyOfRange(preorder,inorderIndex+1,preorder.length);
        int [] inorderRightSubTree = Arrays.copyOfRange(inorder,inorderIndex+1,inorder.length);
        
        root.left = buildTree(preorderLeftSubTree,inorderLeftSubTree);
        root.right = buildTree(preorderRightSubTree, inorderRightSubTree);
        
        return root;
    }
}