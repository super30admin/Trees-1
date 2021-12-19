import ValidateBST.TreeNode;

public class CreateBSTINandPRE {
	
	public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

    public TreeNode fun(int[] preorder, int[] inorder, int l, int r, int p){
        
        if(l>r||p>inorder.length-1){return null;}
        
        TreeNode node= new TreeNode(preorder[p]);
        
        int pointer=l;
        
        for( int i=l; i<=r; i++){
            
            if(inorder[i]!=preorder[p]){
                
            }else{
                
                pointer=i;
            }
        }
        
        node.left=fun(preorder,inorder,l,pointer-1,p+1);
        node.right=fun(preorder,inorder,pointer+1,r,p+(pointer-l+1));
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        return fun(preorder,inorder,0,preorder.length-1,0);
        
    }
}
