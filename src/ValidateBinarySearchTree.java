/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(h) where h is height if tree.
 */
public class ValidateBinarySearchTree {

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

	TreeNode pre = null;

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		return inorder(root);

	}

	private boolean inorder(TreeNode root) {

		// Stack<TreeNode> st= new Stack<>();

		// while(root!=null || !st.isEmpty() ){

		// base
		if (root == null)
			return true;

//	             while(root!=null){

//	                 st.push(root);
//	                 root= root.left;

//	             }

		if (inorder(root.left) == false)
			return false;

		// root= st.pop();

		if (pre != null && pre.val >= root.val)
			return false;
		pre = root;
		// root= root.right;
		return inorder(root.right);
		// }

//	         return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ValidateBinarySearchTree objIn = new ValidateBinarySearchTree();

		

	}

}
