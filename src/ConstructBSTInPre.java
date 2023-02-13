// Time Complexity : O(N)
// Space Complexity : O(N) (Recursion stack + hashmap)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

import java.util.HashMap;
import java.util.Map;

/**
 * Put inorder indices in a map so that finding the right index will be O(1).
 * Then take a global index to find the preorder index position. Take this
 * indexed val as the root and for root with left as 0 and right n-1. Now,
 * for root.left update right as index -1 from map of the current val and for
 * root.right update left as index +1 from map of the current val.
 *
 */
class Solution {
    int preOrderIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int left, int right) {
        if(left > right)
            return null;
        
        int val = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, left, map.get(val) - 1);
        root.right = helper(preorder, map.get(val) + 1, right);
        return root;
    }
}}
