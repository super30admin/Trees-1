// Time Complexity: For Recursive, O(n). For Iterative, O(n*h)
// Space Complexity: For Recursive, O(n) - Recursion Stack Space. For Iterative, O(n) - Stack Space
// Did this code successfully run on Leetcode: Yes
// Any problems faced: No
import java.util.Stack;

public class ValidateBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class RecursiveSolution {
		public boolean isValidBST(TreeNode root) {
			return isValid(root, null, null);
		}

		private boolean isValid(TreeNode root, Integer min, Integer max) {
			if (root == null)
				return true;
			if (max != null && root.val >= max)
				return false;
			if (min != null && root.val <= min)
				return false;
			return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
		}
	}
	
	class IterativeSolution {
	    public boolean isValidBST(TreeNode root) {
	        if(root == null) return true;
	        Stack<TreeNode> st = new Stack<>();
	        TreeNode prev = null;
	        while(root != null || !st.isEmpty()){
	            while(root != null){
	                st.push(root);
	                root = root.left;
	            }
	            root = st.pop();
	            if(prev != null && root.val <= prev.val) return false;
	            prev = root;
	            root = root.right;
	        }
	        return true;
	    }
	}
}
