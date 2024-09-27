// Time Complexity : O(N x N) as we will have to go array N times for each N.
// Space Complexity : O(N) as we will create arrays at each recursion.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really.

import java.util.*;

public class BTFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        
        int index = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] pre_left = Arrays.copyOfRange(preorder, 1, index + 1);
        
        int[] in_right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] pre_right = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        
        root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right, in_right);
        
        return root;
    }

    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
