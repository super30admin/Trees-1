// Time Complexity : O(n)
// Space Complexity : O(h), h -> Height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
	List<Integer> inorder = new ArrayList<Integer>();

	private void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		inorder.add(root.val);
		inorderTraversal(root.right);
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		inorderTraversal(root);

		for (int i = 0; i < inorder.size() - 1; i++) {
			if (inorder.get(i) >= inorder.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidateBST obj = new ValidateBST();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);

		System.out.println("Is the given tree a valid BST? " + (obj.isValidBST(root) == true ? "Yes" : "No"));
	}

}
