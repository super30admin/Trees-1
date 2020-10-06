package com.javaDwarf.binaryTrees.leetcode;

public class _98_ValidateBinarySearchTree {



	public static void main(String[] args) {
		/*TreeNode l1 = new TreeNode(96);
		TreeNode l2 = new TreeNode(12);
		TreeNode l3 = new TreeNode(13);
		TreeNode l4 = new TreeNode(52);
		TreeNode l5 = new TreeNode(29);


		l1.left = l2;
		l2.right = l3;
		l3.right = l4;
		l4.left = l5;

		System.out.println(isValidBST(l1));*/

		TreeNode l1 = new TreeNode(0);

		System.out.println(new _98_ValidateBinarySearchTree().isValidBST(l1));

	}

//Time and space o(n)
	//Logic : check inorder should be in increasing order.

	TreeNode prev = null;
	boolean isBST = true;

	public  boolean isValidBST(TreeNode root) {
		prev = null;
		isBST = true;
		inorder(root);
		return isBST;
	}

	public   void inorder(TreeNode root) {
		if(root == null || !isBST) return ;
		inorder(root.left);
		if(prev != null && root.val <= prev.val) {
			isBST = false;
		}
		prev = root;
		inorder(root.right);
	}
	
	// Logic wont work
	public  boolean isValidBST1(TreeNode root) {
		if(root == null) return true;
        if(root.left != null && root.left.val > root.val) return false;
        if(root.right != null && root.right.val < root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
	}


	/*

      TreeNode prev = null;

	public  boolean isValidBST(TreeNode root) {
		prev = null;
		return isValidBST(root, true);
	}

	public   boolean isValidBST(TreeNode root, boolean isBST) {
		if(root == null || !isBST) return isBST;

		isBST = isValidBST(root.left, isBST);

		if(prev != null && root.val <= prev.val) {
			isBST = false;
		}
		prev = root;

		isBST = isValidBST(root.right, isBST);

		return isBST;
	}

     public boolean isValidBST(TreeNode root, TreeNode prev, boolean result) {
        if(root == null) return result;

        boolean leftResult = isValidBST(root.left, root, result);

        boolean currResult = true;
        if(prev != null && prev.val > root.val){
            currResult = false;
        }
        prev = root;

        boolean rightResult = isValidBST(root.right, root, result);

        return leftResult && currResult && rightResult;
    }*/



}
