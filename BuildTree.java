// Time Complexity : O(n)
// Space Complexity : O(n)

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
    Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.index = 0;
        this.map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[]preorder, int start, int end){
        //base case
        if(start > end)
            return null;
        //logic
        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = map.get(root.val);
        index++;
        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}