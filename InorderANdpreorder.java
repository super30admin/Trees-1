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
    //Time O(N)
    //Space O(N)
    HashMap<Integer,Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        {
            return null;
        }
        map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++)
        {
            map.put(inorder[i] , i);
        }
        return helper(preorder,0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder, int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        int inIndex = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, start, inIndex-1);
        root.right = helper(preorder, inIndex+1, end);
        return root;
    }
}