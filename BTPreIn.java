// Time Complexity : O(n)
// Space Complexity : O(m +n) n : maxDepth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class BTPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }

        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
        int[] preorder_left = Arrays.copyOfRange(preorder, 1 , index+1);
        int[] inorder_right = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] preorder_right = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        root.left = buildTree(preorder_left,inorder_left);
        root.right = buildTree(preorder_right,inorder_right);

        return root;
    }
}
