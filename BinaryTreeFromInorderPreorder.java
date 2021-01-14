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
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return buildTree(inMap, preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> inMap, int[] pre, int p1, int p2, int i1, int i2) {
        if (p1 > p2 || i1 > i2)
            return null;

        int val = pre[p1];
        TreeNode root = new TreeNode(val);
        
        int inIndex = inMap.get(val);
        int preIndex = inIndex - i1;

        root.left = buildTree(inMap, pre, p1 + 1, p1 + preIndex, i1, inIndex - 1);
        root.right = buildTree(inMap, pre, p1 + 1 + preIndex, p2, inIndex+1, i2);

        return root;
    }
}

//Time complexity : O(n) N is the number of elements in the tree that is length of array
//Space complexity : O(N+h) n is the number of elements in the inorder array and h is the height of recursive tree
