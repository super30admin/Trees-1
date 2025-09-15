// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We take one item at a time from pre-order array since that is guranteed to be the next root. Then we use in order array to decide if the current item is in left sub tree or right sub tree.
 */
class Solution {
    int idx;
    Map<Integer, Integer> inOrderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // When pointers cross each other, there is no node
        if (start > end)
            return null;

        // Take the current node from preorder as root and increase the pointer by 1
        int rootVal = preorder[idx];
        idx++;

        // Deciding the span of left and right sub trees and setting the children nodes
        int rootIdx = inOrderMap.get(rootVal);
        return new TreeNode(rootVal, helper(preorder, start, rootIdx - 1), helper(preorder, rootIdx + 1, end));
    }
}