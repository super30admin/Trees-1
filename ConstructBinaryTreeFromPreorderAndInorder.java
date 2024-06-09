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
    int index;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        map = new HashMap<>();
        index = 0;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode dfs(int[] preorder, int start, int end) {
        // base
        if(start > end) {
            return null;
        }
        // logic
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = dfs(preorder, start, rootIndex - 1);
        root.right = dfs(preorder, rootIndex + 1, end);
        return root;
    }
}
