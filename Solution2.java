//Leetcode Problem : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * The first element of a preorder traversal is always the root. The elements to the left of the root in the inorder traversal form the left subtree of the root and the
 * elements to the right side of the root form the right subtree. I use this concept recursively to build the tree. Base Condition : If preorder.length==0, return null. 
 */

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
        if(preorder.length==0)
        {
            return null;
        }
        int rootVal = preorder[0];
        int index = -1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)
            {
                index=i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int inorderLeft[] = Arrays.copyOfRange(inorder,0,index);
        int inorderRight[] = Arrays.copyOfRange(inorder,index+1, inorder.length);
        int preorderLeft[] = Arrays.copyOfRange(preorder, 1,inorderLeft.length+1);
        int preorderRight[] = Arrays.copyOfRange(preorder, index+1, preorder.length);
        root.left = buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight,inorderRight);
        return root;
    }
}