// Time Complexity : O(n)
// Space Complexity : O(n) For the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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

    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int index = 0;
    TreeNode root;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0) return null;

        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }

        return build(preorder, inorder, 0,inorder.length - 1);


    }


    TreeNode build(int[] preorder, int[] inorder, int low, int high)
    {
        if(low > high) return null;

        int rootIndex = inorderMap.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, inorder, low, rootIndex-1);
        root.right = build(preorder, inorder, rootIndex+1, high);


        return root;

    }
}
