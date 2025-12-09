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

// Approach: Recursion using map
// Time: O(N)
// Space: N for map + N for recursive stack ~= O(N)
 class Solution {

    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Populate inorder map with values and indices
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderMap.put(inorder[i], i);
        }
        preIndex = 0;
        return helper(preorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int start, int end) {
        
        // base
        if (start > end) {
            return null;
        }

        // logic
        // find root in preorder
        int rootVal = preorder[preIndex];
        preIndex ++;
        // find root in inorder
        int rootIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        // recurse
        root.left = helper(preorder, inorderMap, start, rootIndex - 1);
        root.right = helper(preorder, inorderMap, rootIndex + 1, end);

        return root;
    }
}
