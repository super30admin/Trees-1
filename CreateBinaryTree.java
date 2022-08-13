// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0)
            return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx =0;
        for(int i = 0;i<inorder.length;i++){
            if(rootVal == inorder[i]){
                idx=i;
                break;
            }
        }
        int[] ileft=Arrays.copyOfRange(inorder,0,idx);
        int[] pleft=Arrays.copyOfRange(preorder,1,ileft.length+1);
        int[] pright=Arrays.copyOfRange(preorder,ileft.length+1,preorder.length);
        int[] iright=Arrays.copyOfRange(inorder,idx+1,inorder.length);
       root.left = buildTree(pleft,ileft);
       root.right = buildTree(pright,iright);
        return root;
    }
    
  
}
