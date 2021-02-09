//Time : O(2*n *n) : 2*n operations for every node. There are n nodes
//Space: O(4 * n/2)

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
    public TreeNode buildTree(int[] pre, int[] in) {
      if(pre.length == 0){
        return null;
      }
      TreeNode root = new TreeNode(pre[0]); // at every node, all the below O(n) operations are performed. There are n nodes
      
      if(root == null){
        return root;
      }
      int index = -1;
      int i = 0;
      while(i < in.length){
        if(in[i] == root.val){
          index = i;
          break;
        }
        i++;
      }
      
      int[] inLeft = Arrays.copyOfRange(in,0,index);
      int[] inRight = Arrays.copyOfRange(in,index+1,in.length);
      
      int[] preLeft =  Arrays.copyOfRange(pre,1,index+1);
        int[] preRight = Arrays.copyOfRange(pre,index+1,pre.length);
      
      root.left = buildTree(preLeft,inLeft);
      root.right = buildTree(preRight,inRight);
      
      return root;
    }
}
