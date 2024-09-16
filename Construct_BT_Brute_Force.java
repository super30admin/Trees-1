
// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;

class TreeNode2 {

	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2() {
	}

	TreeNode2(int val) {
		this.val = val;
	}

	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Construct_BT_Brute_Force {
	public static TreeNode2 buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		TreeNode2 root = new TreeNode2(preorder[0]);
		int index = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				index = i;
			}
		}
		int preLeft[] = Arrays.copyOfRange(preorder, 1, index + 1);
		int preRight[] = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		int InLeft[] = Arrays.copyOfRange(inorder, 0, index);
		int InRight[] = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		root.left = buildTree(preLeft, InLeft);
		root.right = buildTree(preRight, InRight);
		return root;
	}
}