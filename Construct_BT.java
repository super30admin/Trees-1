
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
import java.util.HashMap;

class TreeNode3 {

	int val;
	TreeNode3 left;
	TreeNode3 right;

	TreeNode3() {
	}

	TreeNode3(int val) {
		this.val = val;
	}

	TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Construct_BT {
	int index;
	HashMap<Integer, Integer> map;

	public TreeNode3 buildTree(int[] preorder, int[] inorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, inorder, 0, inorder.length);
	}

	public TreeNode3 helper(int preorder[], int inorder[], int start, int end) {
		// base
		if (start > end || index == preorder.length) {
			return null;
		}
		// logic
		TreeNode3 root = new TreeNode3(preorder[index]);
		int idx = map.get(root.val);
		index++;
		root.left = helper(preorder, inorder, start, idx - 1);
		root.right = helper(preorder, inorder, idx + 1, end);
		return root;
	}
}
