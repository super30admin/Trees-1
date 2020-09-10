// Time Complexity :O(n) n=number of nodes in given tree
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0){
            return null;
        }
        
        int index=-1;
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
               index = i;
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left=buildTree(preLeft,inLeft);
        root.right=buildTree(preRight,inRight);
        
        return root;
        
    }
}