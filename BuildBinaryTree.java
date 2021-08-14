/* Time Complexity :  O(n) where n is the length of preorder array/no of nodes
   Space Complexity : O(n)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
    HashMap<Integer,Integer> hm;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder ==null || preorder.length==0) return null;
        hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            hm.put(inorder[i],i);
        }
        return helper(preorder, 0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        if(start>end)
            return null;
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        int index = hm.get(root.val);
        root.left=helper(preorder,start,index-1);
        root.right=helper(preorder,index+1,end);
        return root;
    }
}