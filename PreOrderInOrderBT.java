// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 *
 */

// Your code here along with comments explaining your approach
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        int preIdx = 0;
        
        inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(preorder, inorder, preIdx, 0, n - 1, n);

    }

    private TreeNode helper(int[] preorder, int[] inorder, int preIdx, int inStrtIdx, int inEndIdx, int n) {
       
        if(preIdx >= n || inStrtIdx > inEndIdx) {
            return null;
        }

        int element = preorder[preIdx];
        TreeNode root = new TreeNode(element);
        int position = inMap.get(element);

        root.left = helper(preorder, inorder, preIdx + 1, inStrtIdx, position -1, n);
        root.right = helper(preorder, inorder, preIdx + (position - inStrtIdx + 1), position + 1, inEndIdx, n);


        return root;
    }
}