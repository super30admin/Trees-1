// Time Complexity :O(n)
// Space Complexity :O(h) -> h is the height of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
 * Started by keeping lower and upper bounds. While traversing the left subtree, I am keeping the upper bound as the previous root value.
 * Similary, while traversing the right subtree I am keeping the lower bound to be the previous root value.
 */

    public boolean isValidBST(TreeNode root) {
        
    	return isValidBSTHelper(root,null,null);
    }
    
    public boolean isValidBSTHelper(TreeNode root, Integer low, Integer high) {
    	
    	if(root == null)
    		return true;
    	
    	if((low!=null && root.val<=low)||(high!=null && root.val>=high))
    		return false;
    	
    	return (isValidBSTHelper(root.left,low,root.val) && isValidBSTHelper(root.right,root.val,high));
    }

 // Time Complexity :O(n)
 // Space Complexity :O(h) -> height of the tree
 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this :no


 // Your code here along with comments explaining your approach
 /*
  *	The tree is built by keeping the indexes of preorder as the root. Checking the same in the inorder, we will be able to find which forms the left
  *	subtree and which forms the right subtree. 
  */
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTreeHelper(preorder,inorder);
    
    }
    
    
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder){
        
        if(preorder==null || preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int index = -1;
        
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                index = i;
                break;
            }                
        }
        
        //divides the preorder array based on index to get left and right subtree
        int[] preLeft = Arrays.copyOfRange(preorder,1,index+1);
        int[] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);
        
        //divides the inorder array based on index to get the left and right subtree
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        
        root.left = buildTreeHelper(preLeft,inLeft);
        root.right = buildTreeHelper(preRight,inRight);
        
        return root;
    }
 