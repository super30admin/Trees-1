

//idea:  recrusive solution. pass left node and check if left node value is grater than root then not BST.
//pass right node and check if  its  value is less than root value then not BST.

//time complexity o(n)
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:yes

public class ValidateBST {
	 static  class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	

     public static boolean isValidBST(TreeNode root) {
		   return helper(root, null, null);
		 }
		 
     
 	public static boolean helper(TreeNode node, Integer lower, Integer upper) {
		   if (node == null) return true;
		   int val = node.val;
		   if (lower != null && val <= lower) return false;
		   if (upper != null && val >= upper) return false;
		   if (! helper(node.right, val, upper)) return false;
		   if (! helper(node.left, lower, val)) return false;
		   return true;
		 }
	public static void main(String[] args) {
				TreeNode nums = new TreeNode(2);
				nums.left =new TreeNode(1);
				nums.right = new TreeNode(3);
				
				boolean result = isValidBST(nums);
				System.out.println("BST IS="+ result);
	}

}
