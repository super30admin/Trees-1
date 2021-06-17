// Time Complexity : O(N)
// Space Complexity : O(N) // hashmap size 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Place inorder array into hashmap with index as value.
 * 2. take preorder start index element as root.
 * 3. find index of element in map.
 * 4. iterate left part of index as left tree and right part as right tree.
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorder {
	Map<Integer, Integer> map;
	int preIndex;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder,0,inorder.length-1);
	}
	
	private TreeNode helper(int[] preorder,int start,int end) {
		
		//condition
		if(start>end) return null;
		//logic
		int rootValue = preorder[preIndex++];
		int inIndex = map.get(rootValue);
		TreeNode root= new TreeNode(rootValue);
		
		root.left= helper(preorder,start,inIndex-1);
		root.right=helper(preorder,inIndex+1,end);
		return root;		
	}
	
	public static void main(String[] args) {
		TreeNode root = new ConstructBinaryTreePreorderInorder().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}) ;
		
		printPreorder(root);
		System.out.println();
		printInorder(root);
	}
	
	private static void printInorder(TreeNode root) {
		//condition
		if(root==null) return;
		printInorder(root.left);
		//logic
		System.out.print(root.val+"..");
		printInorder(root.right);
	}
	
	private static void printPreorder(TreeNode root) {
		//condition
		if(root==null) return;
		//logic
		System.out.print(root.val+"..");
		printPreorder(root.left);
		printPreorder(root.right);
	}

}

class TreeNode {
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
