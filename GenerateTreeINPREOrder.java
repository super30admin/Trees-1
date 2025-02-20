/*Time Complexity: O(n) as we are creating each node once.
Space Complexity: O(n) as we are storing index and value map in a hashmap
Leetcode: yes
Any Issues: NO
*/

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
           this.left = left;
            this.right = right;
      }
}

class Solution {
    int preOrderIndex;
    private TreeNode helper(int[] preorder, Map<Integer, Integer> map, int start, int end)
    {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);
        int rootidx = map.get(root.val);
        root.left =  helper(preorder, map, start, rootidx-1);
        root.right = helper(preorder, map, rootidx+1, end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, map, 0, inorder.length-1);
    }
}