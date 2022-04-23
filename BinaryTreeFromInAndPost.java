public class BinaryTreeFromInAndPost {
    
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        
        
        return helper(postOrder,inOrder,0,postOrder.length-1,0,inOrder.length-1);
     }
     
     public  TreeNode helper(int[] po,int in[],int siPo,int eiPo, int siIn,int eiIn)
     {
         if(siIn>eiIn)
         {
             return null;
         }
         
         TreeNode root = new TreeNode(po[eiPo]);
         
         int position = -1;
         for(int i =siIn;i<=eiIn;i++)
         {
             if(in[i]==root.val)
             {
                 position=i;
                 break;
             }
         }
         
         
         root.left= helper(po,in,siPo,siPo+(position-1-siIn),siIn,position-1);
         root.right = helper(po,in,siPo+(position-1-siIn)+1,eiPo-1,position+1,eiIn);
         
         return root;
         
     }
}
