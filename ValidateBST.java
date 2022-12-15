
//Time Complexity :O(N) , N in Traversing tree 
//Space Complexity :O(H) // H is the height of the tree, space would be used in call stack 
//Did this code successfully run on Leetcode :yes
//Three line explanation of solution in plain english: Tricky part is to declare Prev in class scope.  

//Your code here along with comments explaining your approach


public class ValidateBST {
	
	  
    TreeNode prev = null;
    boolean result = true;
    
    public boolean isValidBST(TreeNode root) {
     
        if(root==null)
            return true;
        helper(root);
        return result;
     }
    public void helper(TreeNode root){
       // base condition 
        if(root ==null)
            return ;
        
      
        System.out.println("Root "+ root);System.out.println("Prev "+prev );
        // logic 
        helper(root.left);
        
         if(prev!=null && prev.val>=root.val)
        {
            result = false;
        }
        
        prev = root;
        
        helper(root.right);
    }
	
	
	public boolean isValidBSTMinMax(TreeNode root) {
	        
	        if(root ==null)
	            return true;
	        boolean leftValidate =  helper(root.left,Integer.MIN_VALUE,root.val);
	        boolean rightValidate = helper(root.right,root.val,Integer.MAX_VALUE);
	        
	        return leftValidate && rightValidate;
	        
	     }
	    
	    public boolean helper(TreeNode root, int min, int max){
	        // base 
	        if(root==null)
	            return true;
	        // logic
	        
	        if(root.val < max  && root.val >min ){
	            return  helper(root.left,min,root.val) &&                               
	                helper(root.right,root.val,max);
	        }
	        
	        else return false;
	        
	    }
}
