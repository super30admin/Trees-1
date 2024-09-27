/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



/*
Time Complexity: O(n^2)
Space Complexity: O(n)
Did the code run on leetcode? Yes
Approach: take the first value from preorder for the root and then find it in inorder to divide it  and use it for index. 
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0 || inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for(int i =0; i<inorder.length; i++){
            if(root.val==inorder[i]){
                index = i;
            break; }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight =  Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);

           root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;

    }
} 

