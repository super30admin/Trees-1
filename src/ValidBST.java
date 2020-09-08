import java.util.Stack;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode prev = null;
		while (root != null || !st.isEmpty()) {

			while (root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			if (prev!=null && root.val <= prev.val)
				return false;
			prev = root;
			root = root.right;
		}

		return true;

	}

	public static void main(String[] args) {
		
		TreeNode left = new TreeNode(1,null,null);
		TreeNode right = new TreeNode(3,null,null);
		TreeNode root = new TreeNode(2,left,right);
		ValidBST bst = new ValidBST();
		System.out.println("is my tree BST :"+bst.isValidBST(root));
	
	}
}
