// TC: O(n) where N represents the number of elements in the Tree.
// SC: O(n) since we are using extra data structure for storing N elements in stack.

// We are using inorder traversal for the tree since the inorder traversal goes in descinding to ascending order, if the values that we are processing are
// not in ascending order and we find any element that is smaller than previous, we return false. If all the elements in the tree for inorder traversal are in 
// ascending order, we return true;

import java.util.*;

public class ValidateBST {

	public boolean validateBST(TreeNode root) {
		
		
		if(root==null)return true;
		Stack<TreeNode> st = new Stack<TreeNode>();
		double inorder = - Double.MAX_VALUE;
		
		while(!st.isEmpty() || root!=null) {
			
			while(root!=null) {
				st.push(root);
				root = root.left;
			}
			
			root = st.pop();
			int val = root.val;
			
			if(val<inorder)return false;
			inorder = val;
			root = root.right;
			
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		ValidateBST vb = new ValidateBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		System.out.println(vb.validateBST(root));
	}
}
