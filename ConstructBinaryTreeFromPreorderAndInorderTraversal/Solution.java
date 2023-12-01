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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * First element in preorder is the root of the tree. Next is left root and then right root. Elements to the left and right of this
 * root is the left and right subtree resp. in inorder traversal.
 * To find root index from the inorder, create a HashMap -> (element, index) instead of iterating over the inorder array everytime
 */
class Solution {

    Map<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();
        index = 0;
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);

        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {

        if(start > end) return null;

        int rootValue = preorder[index];
        index++;
        int rIdx = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, start, rIdx-1);
        root.right = helper(preorder, rIdx+1, end);

        return root;
    }
}

/*
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;

        int rootValue = preorder[0];
        int rIdx = -1;
        for(int i=0; i<inorder.length; i++)
            if(inorder[i] == rootValue)
                rIdx = i;

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1+inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1+inLeft.length, preorder.length);

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}*/
