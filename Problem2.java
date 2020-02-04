/* Construct binary treee from inorder and preorder traversal */

// Time Complexity : O(n) as we will be visiting all nodes once
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//We will start with preorder we will pick the first element of preorder
//then we will search for that element in inorder, then:
//1.all elements on its left are for left subtree
//2. all elements on right side are for right subtree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        //Edge case
        if(preorder.length == 0) return null;
        //assign root as first index value in preorder array
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        //iterate over inorder array
        for(int i = 0; i < inorder.length; i++){
            //if you get root value from preorder in inorder array, initialise index and break
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        //initialise and build tree from left and right preorder and inorder arrays
        int[] preleft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preright = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        return root;
    }
}