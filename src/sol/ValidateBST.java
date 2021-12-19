package sol;

import java.util.Stack;

public class ValidateBST {
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
	 public boolean isValidBST(TreeNode root) {
         
	        Stack <TreeNode> s= new Stack<>();
	        
	        TreeNode previous=null;
	        
	        while(!s.isEmpty()||root!=null){
	            
	            while(root!=null){
	                
	                s.push(root);
	                root=root.left;
	            }
	           
	           TreeNode node=s.pop();
	          
	            if(previous!=null&&previous.val>=node.val){return false;}
	            
	                 previous=node;
	                 root=node.right;
	            
	        }
	        
	        
	        return true;

	    }
	
}
