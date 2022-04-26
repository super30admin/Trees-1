// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes

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
    public HashMap<Integer,Integer> m = new HashMap<>();
    public int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
        return helper(0,inorder.length-1,preorder);
    }
    public TreeNode helper(int iStart,int iEnd,int[] preorder){ 
        if(iEnd<iStart){
            return null;
        }
        int rootVal = preorder[idx];
        TreeNode n = new TreeNode(rootVal);
        idx++;
        int rootIdx = m.get(rootVal);
        n.left=helper(iStart,rootIdx-1,preorder);
        n.right=helper(rootIdx+1,iEnd,preorder);
        return n;
    }
}