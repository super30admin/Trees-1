/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Beats 70% of Java Submissions
// T: O(2 ^ n)
// S: O(n) - For hashMap
// Using Recursion, we use the preorder for getting the root node and inorder to decide which elements lie to the left and right side of the root.
class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // We define a HashMap to get access to inorder elements in constant time
        
        
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        
        if(preStart > preEnd || inStart > inEnd)    return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int rootInInorder = map.get(preorder[preStart]);
        
        int numsDiff = rootInInorder - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preorder.length - 1, inorder, inStart, rootInInorder - 1);
        
        root.right = buildTree(preorder, preStart + numsDiff + 1, preorder.length - 1, inorder, rootInInorder + 1, inEnd);
            
        return root;
    }
}