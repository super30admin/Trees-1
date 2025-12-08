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
import java.util.HashMap;
import java.util.Map;
class Solution {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        idx = 0;
        return helper(preorder, idx, preorder.length-1, map);
    }

    private TreeNode helper(int[] preorder, int start, int end, Map<Integer, Integer> map)
    {
        if(start > end) return null;
        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx -1, map);
        root.right = helper(preorder, rootIdx + 1, end, map);

        return root;
    }
}