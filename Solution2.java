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

// Time Complexity : O(N)
// Space Complexity : O(max(depth)+N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :
find root from preorder, & use this to find left & right size in inorder. Use size to find next left & right subtrees

// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder,int inorderStart, int inorderEnd){
        if(preorderStart>preorderEnd || inorderStart> inorderEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);
        int index = map.get(preorder[preorderStart]);
        int leftTreeSize = index - inorderStart;

        root.left = helper(preorder, preorderStart+1, preorderStart+leftTreeSize, inorder, inorderStart, index-1);
        root.right = helper(preorder,preorderStart+1+leftTreeSize, preorderEnd, inorder, index+1,inorderEnd);

        return root;
    }
}