// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int rootVal = preorder[0];

        // find rootVal in inorder to get left and right
        int rootIdx = -1;
        TreeNode root = new TreeNode(rootVal);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIdx = i;
            }
        }
        int [] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inorderRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length+1);
        int [] preRight = Arrays.copyOfRange(preorder, 1+preLeft.length, preorder.length);

        root.left = buildTree(preLeft, inorderLeft);
        root.right = buildTree(preRight, inorderRight);
        return root;
    }
}

