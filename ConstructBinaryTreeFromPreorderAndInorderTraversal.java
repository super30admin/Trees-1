import java.util.*;

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length - 1,preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int []preorder, int inorder[]){
        if(preStart > preorder.length - 1 || inStart > inEnd)   return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;

        for(int i = inStart; i <= inEnd ; i++){
            if(root.val == inorder[i]){
                inIndex = i;
            }
        }

        root.left = helper(preStart+1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
