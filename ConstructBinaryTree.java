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

//TC: o(n)2
//SC: o(n)2
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //base case
        if(preorder.length==0) 
        {
            return null;
        }

        //find the root value from preorder
        int rootval = preorder[0];

        //form the root node with rootval
        TreeNode root = new TreeNode(rootval);

        //find the root's index in inorder so left of root is left subtree and right of root is right subtree
        int rootindex = 0;
        for(int i =0; i<inorder.length;i++){
            if(inorder[i]==rootval){
                rootindex = i;
                break;
            }
        }

        //with the root index in inorder array find the new in order and pre order for left subtree and right subtree
        //copyOfRange - function parameters(array,first index, lastindex+1) similar to substring
        int [] inorderleft = Arrays.copyOfRange(inorder,0 , rootindex);
        int [] inorderright = Arrays.copyOfRange(inorder, rootindex+1, inorder.length);
        int [] preorderleft = Arrays.copyOfRange(preorder, 1 , inorderleft.length+1 );
        int [] preorderright = Arrays.copyOfRange(preorder,inorderleft.length+1 ,preorder.length);

        //recursive call the left subtree and right subtree
        root.left = buildTree(preorderleft,inorderleft);
        root.right =  buildTree(preorderright, inorderright);

        return root;



    }
} 
