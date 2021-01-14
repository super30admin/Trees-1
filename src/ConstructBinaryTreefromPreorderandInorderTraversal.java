
/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(n) where n is no of elements.
 */

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	HashMap<Integer, Integer> map;
	int idx;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0)
			return null;

		map = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {

		if (start > end)
			return null;

		int rootval = preorder[idx];
		idx++;

		TreeNode root = new TreeNode(rootval);

		int rIdx = map.get(rootval);

		root.left = helper(preorder, inorder, start, rIdx - 1);
		root.right = helper(preorder, inorder, rIdx + 1, end);

		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConstructBinaryTreefromPreorderandInorderTraversal objIn = new ConstructBinaryTreefromPreorderandInorderTraversal();

	}

}
