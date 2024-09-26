// Time Complexity :O(n)
// Space Complexity :O(h) h is the height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root)
    {
        if(root==null)
            return true;
        if(inorder(root.left)==false)
            return false;
       
        if(prev!=null&&prev.val>=root.val)return false;
         prev=root;
        return inorder(root.right);
    }
}
-------------------------------------------------------------------------------------------------------------
// Time Complexity :O(h*n)where h is the height of the tree
// Space Complexity :Exponential
// Did this code successfully run on Leetcode :
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length==0)
          return null;
        TreeNode root= new TreeNode(preorder[0]);
        int index=-1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==root.val)
                index=i;
        }
        int[] preLeft=Arrays.copyOfRange(preorder,1,index+1);
        int[] preRight=Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] inLeft=Arrays.copyOfRange(inorder,0,index);
        int[] inRight=(Arrays.copyOfRange(inorder,index+1,inorder.length));
         root.left=buildTree(preLeft,inLeft);
            root.right=buildTree(preRight,inRight);
        return root;
        }
    
}