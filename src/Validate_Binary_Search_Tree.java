import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/*********************************Approach 1: Iterative using Inorder Traversal*************************************/
//Time Complexity : O(n), each node is visited exactly once
//Space Complexity : O(h), h is height of the tree
//Did this code successfully run on Leetcode : Yes

/*By using Inorder traversal (left-->root-->right) and maintaining a previous node pointer and compares it's value for a violation of the BST */
public class Validate_Binary_Search_Tree {
	public static boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		TreeNode prev = null;
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();


			if(prev != null && prev.val >= root.val)	//If next element in inorder traversal is smaller than the previous one that's not BST.
				return false;

			prev = root;
			root = root.right;
		}
		return true;
	}


	/*********************************Approach 2: Recursive using Inorder Traversal*************************************/
	//Time Complexity : O(n), each node is visited exactly once
	//Space Complexity : O(h), h is height of the tree
	//Did this code successfully run on Leetcode : Yes

	//Your code here along with comments explaining your approach
	public class Validate_Binary_Search_Tree {
		static TreeNode prev = null;
		public static boolean isValidBST(TreeNode root) {
			if(root == null)
				return true;
			return inOrder(root);   
		}
		private static boolean inOrder(TreeNode root){
			if(root == null)
				return true;

			if(inOrder(root.left) == false) // if left subtree is not a BST
				return false;

			if(prev != null && prev.val >= root.val)
				return false;

			prev = root;

			return inOrder(root.right);
		}

	/*********************************Approach 3: Recursion*************************************/
	//Time Complexity : O(n), each node is visited exactly once
	//Space Complexity : O(h), h is height of the tree
	//Did this code successfully run on Leetcode : Yes

	/* Here we check whether every node falls within a particular range, if not return false */
	public class Validate_Binary_Search_Tree {
		public static boolean isValidBST(TreeNode root) {
			return helper(root, null, null);
		}

		private static boolean helper(TreeNode root, Integer minValue, Integer maxValue){
			if(root == null)
				return true;

			if((minValue != null && root.val <= minValue) || (maxValue != null && root.val >= maxValue))
				return false;
			// for left(min->same, max-> root) and right(min->root, max-> same)
			return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
		}


		public static void main(String[] args) {
			TreeNode tree = new TreeNode(); 
			tree = new TreeNode(2); 
			tree.left = new TreeNode(1); 
			tree.right = new TreeNode(3);     

			if (isValidBST(tree)) 
				System.out.println("True"); 
			else
				System.out.println("False");
		}
	}