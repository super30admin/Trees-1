// Time Complexity :O(n^2)
// Space Complexity :O(nlogn)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){return null;}
        int rootval = preorder[0];
        int rootindex=0 ;

        //Find root
        for(int i = 0; i<inorder.length;i++){
            if(inorder[i] == rootval){
                rootindex = i;
            }

        }
        TreeNode root = new TreeNode(rootval);
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootindex+1);
        int[] inorderright = Arrays.copyOfRange(inorder, rootindex+1, inorder.length);
        int[] preorderleft = Arrays.copyOfRange(preorder, 1,rootindex+1);
        int[] preorderright = Arrays.copyOfRange(preorder, rootindex+1, preorder.length);

        root.left = buildTree(preorderleft,inorderleft);
        root.right = buildTree(preorderright, inorderright);
        return root;
    }

}