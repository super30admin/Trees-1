package Q_98._Validate_Binary_Search_Tree;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
// 
//
//Example 1:
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//Example 2:
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.

//Time Complexity  : O(n)  
//Space Complexity : O(1)

public class Solution {


	public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		     public TreeNode() {
				// TODO Auto-generated constructor stub
			}
		 }
	
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}
	
	
	public boolean helper(TreeNode node, Integer min, Integer max) {
		//base case
		if(node == null) {return true;}
		if(max != null && (node.val >= max)) {return false;}
		if(min != null &&node.val <= min) {return false;}
		
		
		
		//logic
		return helper(node.left, min,node.val) && helper(node.right, node.val, max);
		
//		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		System.out.println(s.isValidBST(root));

	}

}
