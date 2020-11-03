import java.util.Stack;

public class ValidBST {
	private boolean inorder(TreeNode root) {
		TreeNode prev = null;
		Stack<TreeNode> st = new Stack<>();
		while (root != null || !st.isEmpty()) {

			while (root != null) {
				st.push(root.left);
				root = root.left;
			}
			root = st.pop();
			if (prev != null && prev.val >= root.val)
				return false;

			prev = root;
			root = root.right;
		}

		return true;

	}
}
