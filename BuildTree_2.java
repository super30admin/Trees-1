/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int index = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        if(preorder.length == 0 || preorder == null)
            return null;
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length-1);
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        
        if(preorder.length == 0 || preorder == null || index >= preorder.length || start > end){
            return null;
        }
            
        
        int inorderIndex = map.get(preorder[index++]);
        
        TreeNode root = new TreeNode(inorder[inorderIndex]);
        
        if(start == end){
            return root;
        }

        
        root.left = helper(preorder, inorder, start, inorderIndex-1);
        root.right = helper(preorder, inorder, inorderIndex+1, end);
        
        return root;
    }
}