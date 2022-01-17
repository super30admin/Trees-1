//Time Complexity : O(n)
//Space Complexity : O(n)
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
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0)
            return null;
        map = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);

    }

    public TreeNode helper(int[] preorder, int start, int end) {

        if (start > end)
            return null;

        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootidx = map.get(rootVal);
        root.left = helper(preorder, start, rootidx - 1);
        root.right = helper(preorder, rootidx + 1, end);
        return root;
    }
}
