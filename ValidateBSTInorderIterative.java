package binaryTrees;

import java.util.Stack;
/**
 * Tip: Inorder Traversal of a BST must return a sorted order of elements
 * Time: O(n)
 * Space: O(n)
 * Leetcode Accepted: yes
 * Problems faced: No
 */
public class ValidateBSTInorderIterative {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2); 
        root.left = new TreeNode(3); 
        root.right = new TreeNode(1); 
        System.out.println(isValidBST(root));
	}

	/*
	 * Iterative Inorder traversal using stack
	 */
	private static boolean isValidBST(TreeNode root) {
		Integer prev = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()) {
			//Traverse until the left most element
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			//Visit left or root
			root = stack.pop();
			//Ignore the prev comparison for 1st element
			if(prev != null && root.val <= prev) {
				return false;
			} 
			prev = root.val;
			//Visit right
			root = root.right;
		}
		return true;
	}
}
