// Time Complexity : O(n)
// Space Complexity :O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //TC: O(n)
    //SC : O(2n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || preorder==null) return null;
        
        //Preorder[0] will give us the root value of the entire tree
        TreeNode root = new TreeNode(preorder[0]);
        
        int index=-1;
        
        //Now let's traverse until root node in inorder so that we get the root index in  inorder
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
            }
        }
        
        //Now we need to get the left subtree in preorder to get root
        int[] preLeft = Arrays.copyOfRange(preorder,1,index+1);//starting from 1 because 0 is root
        //Below will give us the right subtree in preorder
        int[] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);
        
        //We need to get the left subtree from inorder to determine immediate left to last root node
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        //Below will give us right subtree in inorder to 
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        root.left = buildTree(preLeft,inLeft); // we need to repeat this process for left subtree
        root.right = buildTree(preRight,inRight);// we need to repeat this process for right subtree
        
        return root;
    }
}
