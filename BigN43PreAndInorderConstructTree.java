// time complexity is O(N^2) as build tree is called twice recursively so two for loops (Letme know in comments if I'm right)
// Space complexity  O(N)
// This solution is accepted in leetcode
import java.util.Arrays;
import java.util.HashMap;

public class BigN43PreAndInorderConstructTree {
	HashMap<Integer, Integer> map = new HashMap<>();
	int index = 0;
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			// edge case
			if (preorder.length == 0 || inorder.length == 0) {
				return null;
			}
			for (int i = 0; i < inorder.length; i++) {
				map.put(inorder[i], i);
			}
			return helper(preorder,inorder);
		}

		private TreeNode helper(int[] preorder, int[] inorder) {
			index = map.get(preorder[0]);
			TreeNode Node = new TreeNode(preorder[0]);
			int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
			int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
			int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
			int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
			Node.left = buildTree(preLeft,inLeft);
			Node.right = buildTree(preRight,inRight);
			return Node;
		}
}
