public class ValidBSTUsingRec {
	public boolean isValidBST(TreeNode root) {

		if (root == null) {
			return false;
		}
		return inorder(root);
	}

	private boolean inorder(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return true;

		TreeNode prev = null;
		if (inorder(root.left) == false)
			return false;

		if (prev != null && prev.val >= root.val)
			return false;

		prev = root;
		return inorder(root.right);

	}

}
