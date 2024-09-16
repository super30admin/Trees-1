package Tree;

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
  
  //-node null valid root 
  //- left node val should be upper bound node.val and lower bound is low
  //-right : lower bound node.val and upper bound high
public class Problem1 {
	//Time complexity : O(N) n= number of elements
	//Space Complexity : O(H) H = height of recursion stack

	    public boolean isValidBST(TreeNode root) {
	        return validate(root,null,null);
	    }
	    
	    private boolean validate(TreeNode node,Integer low,Integer high){
	        if(node==null) return true;
	        
	        if((low!=null && node.val<=low ) || (high!=null && node.val>=high)){
	            return false;
	        }
	           
	        return validate(node.left,low,node.val) && validate(node.right,node.val,high);
	    }
	
	    public static void main(String args[]) {
	    	TreeNode root= new TreeNode();
	    }
}
