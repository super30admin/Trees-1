import java.util.Map;
import java.util.HashMap;

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

// Time Complexity: O(n)
// Space Complexity: O(max(h,n)); h = height of tree, n = inorder.length 
// Did this code run on leetcode? : Yes
class Solution {
    private int preorderIndex = 0;
    Map<Integer, Integer> inorderMap;

    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(preorder, left, inorderMap.get(rootVal) - 1);
        root.right = buildTreeHelper(preorder, inorderMap.get(rootVal) + 1, right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length) {
            return new TreeNode();
        }

        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }
}