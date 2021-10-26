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
        if(preorder.length == 0)
            return null;



        TreeNode root = new TreeNode(preorder[0]);
        //Root in Inorder
        int index = -1 ;
        for(int x = 0;x<inorder.length;x++){
            if(inorder[x] == root.val){
                index = x;
                break;
            }

        }
        //Need to create new pre/in order.

        int[] preLeft = Arrays.copyOfRange(preorder,1,index+1);
        int[] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);


        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);


        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);

        return root;

    }
}

//Time Complexity : O(N^2);
//Space Complexity : O(h) where h is upper-bounded by n;
//Did it run on Leetcode : yes