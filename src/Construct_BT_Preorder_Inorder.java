/*class TreeNode {
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
}*/

class Construct_BT_Preorder_Inorder {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, 0, inorder.length - 1);
	}

	public static TreeNode helper(int[]  preorder, int[] inorder,int PreOrderStart, int inOrderStart, int inOrderEnd){
		if(PreOrderStart > preorder.length - 1 || inOrderStart > inOrderEnd)
			return null;

		TreeNode root = new TreeNode(preorder[PreOrderStart]);
		int inOrderIndex = 0;   // index of current root in Inorder
		for(int i =inOrderStart; i<= inOrderEnd; i++){
			if(inorder[i] == root.val)
				inOrderIndex = i;
		}

		root.left = helper(preorder, inorder, PreOrderStart + 1, inOrderStart, inOrderIndex - 1);
		root.right = helper(preorder, inorder, PreOrderStart + inOrderIndex - inOrderStart + 1, inOrderIndex + 1, inOrderEnd);

		return root;
	}
}
