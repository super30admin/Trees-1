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
        if(preorder.length == 0) return null;

        int root = preorder[0];

        TreeNode mainRoot = new TreeNode(root);
        int rootIdx = 0;
        //finding the root in inorder
        for(int i =0;i<inorder.length;i++){
            if(mainRoot.val == inorder[i]){
                rootIdx = i;
            }
        }

        int[] leftPre = Arrays.copyOfRange(preorder,1,rootIdx+1);
        int[] rightPre = Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder,0,rootIdx);
        int[] rightIn = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        mainRoot.left = buildTree(leftPre,leftIn);
        mainRoot.right = buildTree(rightPre,rightIn);

        return mainRoot;

    }
}

//TC O(n^2)
//SC O(n^2)