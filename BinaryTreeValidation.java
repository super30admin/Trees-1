// Time Complexity : O(N)
// Space Complexity : O(H) // H is the height of the tree 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Write code for inorder traversal of the binary tree as it produces output in incremental order.
 * 2. change inorder method signature to return boolean.
 * 3. In the place of printing value check value is less than last element return false.
 * 4. always update prev value  to current value after validation.
 */

public class BinaryTreeValidation {
	private boolean result;

	public boolean isValidBST(TreeNode root) {
		result = true;
		inorder(root,null,null);
		return result;
	}

	private void inorder(TreeNode root,Integer min,Integer max) {
		if (root == null) {
			return;
		}
		inorder(root.left,min,root.val);
		
		if(min!=null && root.val<=min) {
			result = false;
			return;
		}
		if(max!=null && root.val>=max) {
			result = false;
			return;
		}
		
		inorder(root.right,root.val,max);
		
	}
	
	public static void main(String[] args) {
		TreeNode t=new TreeNode(2);
		t.left=new TreeNode(1);
		t.right=new TreeNode(3);
		System.out.println(new BinaryTreeValidation().isValidBST(t));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
