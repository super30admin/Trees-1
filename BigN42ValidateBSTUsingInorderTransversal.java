import java.util.Stack;

//Time complexity is O(n) as we going through all the nodes
//Space complexity is O(1) as we are not using any extra space
//this solution is submitted on leetcode

public class BigN42ValidateBSTUsingInorderTransversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		// Edge
		if (root == null)
			return true;
		Stack<TreeNode> st = new Stack<>();
		TreeNode prev = null;
		while(root!=null || !st.isEmpty()) {
			while(root!=null) {
				st.push(root);
				root = root.left;
			}
			root =st.pop();
			if(prev!=null && root.val <= prev.val) return false;
			prev = root;
			root = root.right;
		}
		return true;
	}
}
