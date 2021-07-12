// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeConstruction {
	Map<Integer, Integer> inorderIndexMap;
	int preorderIndex;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}

		preorderIndex = 0;
		inorderIndexMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return helper(preorder, 0, preorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int start, int end) {
		// Base Case
		if (start > end) {
			return null;
		}

		// Create Node
		int val = preorder[preorderIndex++];
		TreeNode node = new TreeNode(val);
		// Left SubTree
		node.left = helper(preorder, start, inorderIndexMap.get(val) - 1);
		// Right Subtree
		node.right = helper(preorder, inorderIndexMap.get(val) + 1, end);

		return node;
	}

	public void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		BinaryTreeConstruction obj = new BinaryTreeConstruction();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = obj.buildTree(preorder, inorder);
		obj.printInorder(root);
	}

}
