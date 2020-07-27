//Definition for a binary tree node.
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

/*********************************Approach 1: Recursion*************************************/
//Time Complexity : O(n), each node is visited exactly once
//Space Complexity : O(n), since we keep up to the entire tree
//Did this code successfully run on Leetcode : Yes

//Your code here along with comments explaining your approach
public class Validate_Binary_Search_Tree {
	public static boolean isValidBST(TreeNode root) {
		return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean helper(TreeNode root, long minValue, long maxValue){
		if(root == null)
			return true;

		if(root.val <= minValue || root.val >= maxValue)
			return false;
		
		return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);

	}
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(); 
        tree = new TreeNode(2); 
        tree.left = new TreeNode(1); 
        tree.right = new TreeNode(3);     
 
        if (isValidBST(tree)) 
            System.out.println("True"); 
        else
            System.out.println("False");
	}
}
