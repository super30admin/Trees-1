
//Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
//Recursive solution
Time complexity : O(n) // where n is total number of nodes in tree 
Space Complexity: O(2n) // n for Hashset and n for recursive stack
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
    int index=0;
    HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0  ){
            return null;
        }
        
        hm = new HashMap<>();
        
        for(int i=0;i<inorder.length ;i++){
            hm.put(inorder[i],i);
            
        }
        return helper(preorder, inorder, 0, inorder.length-1);
        
    }
    public TreeNode helper(int[] preoder,int[] inorder, int start, int end){
        if(start>end || index>preoder.length-1){
            return null;
        
        }
        int rval= preoder[index];
        TreeNode root= new TreeNode(rval);
        index++;
        int m= hm.get(rval);
        
        if(start== end){
            return root;
        }
        root.left= helper(preoder, inorder,start, m-1);
        root.right= helper(preoder, inorder,m+1, end);
        
        return root;
        
        
        
    }
}