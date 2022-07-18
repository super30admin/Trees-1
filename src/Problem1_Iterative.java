//Time Complexity : O(n)
//Space Complexity : O(h), where h is the height of tree, max length of nodes that will enter the stack.
//Code run successfully on LeetCode.

public class Problem1_Iterative {

	   public boolean isValidBST(TreeNode root) {
	        
	        Stack<TreeNode> s = new Stack<>();
	        TreeNode prev = null;
	        while(root != null || !s.isEmpty()){
	            
	            while(root != null){
	                s.push(root);
	                root = root.left;
	            }
	            
	            root = s.pop();
	            
	            if(prev != null && prev.val >= root.val)
	                return false;
	            prev = root;
	            root = root.right;
	        }
	        return true;
	    }
}
