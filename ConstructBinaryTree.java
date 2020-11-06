

/**
 * The worst case for time complexity is O(N^2). Space complexity is O(N) if we consider the space used for stack
 * The first element of preorder array is the root of the array is the concept taken into consideration where we use recursion to call left and right
 * part of the array to build the left and right part of tree.
 *
 * Yes, the program passed all the test cases in leetcode.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0){return null;}

        int root_number = preorder[0]; int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root_number){
                index = i;
            }
        }

        TreeNode root = new TreeNode(root_number);

        int[] leftPre = Arrays.copyOfRange(preorder,1,index+1);
        int[] leftIn = Arrays.copyOfRange(inorder,0,index);

        root.left = buildTree(leftPre,leftIn);

        int[] rightPre = Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder,index+1,inorder.length);

        root.right = buildTree(rightPre,rightIn);

        return root;
    }
}