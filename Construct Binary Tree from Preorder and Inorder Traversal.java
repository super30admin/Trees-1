Construct Binary Tree from Preorder and Inorder Traversal
 
 Time: O(n)
 Space: O(n)

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
    HashMap<Integer,Integer> h1;
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0) return null;
        
        h1 = new HashMap<>();        
        for(int i=0;i<inorder.length;i++){
            h1.put(inorder[i],i);
        }        
        return helper(preorder,0,inorder.length-1);        
    }
    
    public TreeNode helper(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }
       
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
       
        int ridx = h1.get(root.val);
        
        root.left= helper(preorder,start,ridx-1);
        root.right = helper(preorder,ridx+1,end);
        return root;
        
    }
}