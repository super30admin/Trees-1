// Time Complexity : O(n*2)
// Space Complexity : O(n*2) including recursive stack, else O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//We find root node from preorder first element
//loop through inorder to find the root, so all the elements left of root form left subtree and right of root form right subtree
//we build 4 arrays, 2 left and right for both inorder and preorder and recursively go till the leaf nodes to build tree
//return root in the last


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        int index =-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                
            }
        }
        
         int[] leftPre=Arrays.copyOfRange(preorder,1,index+1);
        int[] leftIn=Arrays.copyOfRange(inorder,0,index);
        
         int[] rightPre=Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] rightIn=Arrays.copyOfRange(inorder,index+1,inorder.length);
       
       
        
        root.left=buildTree(leftPre,leftIn);
        root.right=buildTree(rightPre,rightIn);
        
        return root;
        
    }
}