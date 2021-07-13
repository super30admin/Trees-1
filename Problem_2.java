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
        
        return helper(preorder, inorder);
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder){
        
        if(preorder.length == 0 || preorder == null)
            return null;
        
        index = map.get(preorder[0]);
        
        //System.out.println(preorder[0] + " : "+index + " : ");
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        
        int[] inRight = Arrays.copyOfRange(inorder, (index+1), inorder.length);
        
        int[] preleft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}