package Tree;

import java.util.Arrays;
 class TreeNode {
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
 
 //Time  :O(N) where N = number of elements
 //Space : O(N) where N = recursion stack
 // - preorders firsts node is root then go to inorder and get that node then 
 //- left side inorder would be left sub tree and right side of that root will be right sub tree
 // - use those index od inoreder and send preorder again
 // - get root.left and root.right sub tree and return root;
public class Problem2 {
	  public static TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder==null || preorder.length==0)
	            return null;
	        TreeNode root=new TreeNode(preorder[0]);
	        int index=-1;
	        for(int i=0;i<inorder.length;i++){
	            if(inorder[i]==root.val){
	                index=i;
	                break;
	            }
	        }
	        
	        int[] preleft= Arrays.copyOfRange(preorder,1,index+1);
	          int[] preright= Arrays.copyOfRange(preorder,index+1,inorder.length);
	        
	        int[] inorderleft=Arrays.copyOfRange(inorder,0,index);
	         int[] inorderright=Arrays.copyOfRange(inorder,index+1,preorder.length);

	        root.left=buildTree(preleft,inorderleft);
	        root.right=buildTree(preright,inorderright);
	        
	        return root;
	    }
	  
	  public static void main(String args[]) {
		//  [3,9,20,15,7]
		//  [9,3,15,20,7]
		  int[] preorder= new int[] {3,9,20,15,7};
		  int[] inorder= new int[] {9,3,15,20,7};
		  
		  TreeNode root= buildTree(preorder,inorder);
		 
	  }
}
