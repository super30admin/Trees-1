// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(n).
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
    HashMap<Integer,Integer>hashMap;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        if(preorder.length==0 || inorder.length==0) return null;
        hashMap = new HashMap();
        for(int i=0;i<inorder.length;i++){
            hashMap.put(inorder[i],i);
        }
        
       return inOrder(preorder,inorder,0,inorder.length-1);
    }
    
    private TreeNode inOrder(int[] preorder,int[] inorder,int start,int end){
        
        if(start>end || index>=preorder.length) return null;
        
        int indx=hashMap.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left=inOrder(preorder,inorder,start,indx-1);
        node.right=inOrder(preorder,inorder,indx+1,end);
        return node;
    }
}
