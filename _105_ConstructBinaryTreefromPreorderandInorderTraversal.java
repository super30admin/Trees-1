package com.javaDwarf.binaryTrees.leetcode.construction;


import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {

		int in[] = {2,1,0,2,4,3,2};
		int pre[] = {2,1,2,0,3,4,2};

		TreeNode  x = new _105_ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(pre, in);
		System.out.println(x);
	}
	
	//Time and space o(n)

	public static int current = 0;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		current = 0;
		return buildTree(preorder, inorder,0, inorder.length-1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

		if(start > end) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[current]);

		int mid = -1;
		for(int i=start ; i<=end; i++) {
			if(preorder[current] == inorder[i]) {
				mid = i;
				break;
			}
		}

		current++ ;

		root.left = buildTree(preorder, inorder, start, mid-1);
		root.right = buildTree(preorder, inorder, mid+1, end);

		return root;
	}

}
