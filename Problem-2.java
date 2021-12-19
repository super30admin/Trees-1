// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        
        return helper(preorder,inorder,0,inorder.length-1,map);
    }
    private TreeNode helper(int[] preorder,int[] inorder,int start,int end,HashMap<Integer,Integer> map) {
        if(p==preorder.length || start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[p]);
        int inorderIndex = map.get(preorder[p]);
        
        p++;
        root.left = helper(preorder,inorder,start,inorderIndex-1,map);
        root.right = helper(preorder,inorder,inorderIndex+1, end,map);
        
        
        return root;
    }
}