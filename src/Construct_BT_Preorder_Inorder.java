import java.util.HashMap;

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

/******************************Approach 1: optimized*****************************************************/
//Time Complexity : O(n), where n is the length array(preorder or inorder)
//Space Complexity : O(n), all nodes with index from the hashmap.
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

/* Recursively building left and right subtree.
 * Find the root index from the hashmap and 
 * Recursively find the left subtree and the right subtree from here by dividing the preorder array based on the index */

class Solution {
	HashMap<Integer, Integer> map = new HashMap<>();
	int preOrderIndex = 0;	//root index in preorder
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for(int i=0; i<inorder.length; i++)
			map.put(inorder[i], i);

		return helper(preorder, inorder, 0, inorder.length-1);

	}

	private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
		if(start > end || preOrderIndex == preorder.length)		// base condition
			return null;

		TreeNode root = new TreeNode(preorder[preOrderIndex++]);

		int index = map.get(root.val);	//root index in inorder

		root.left = helper(preorder, inorder, start, index-1);
		root.right = helper(preorder, inorder, index+1, end);

		return root;
	}
}

/***********************************Approach 2: Brute force******************************************************/
// Time Complexity : O(n^2), where n is the length array(preorder or inorder) * each time searching array for the root
// Space Complexity : O(n^2), new copy of the array is created at leaf node
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Recursively build left and right subtree
 * Find the root from preorder (root,left,right) and recursively find the left subtree and the right subtree from here.
 * At each level we create a new arraycopy because arrays are passed a reference */

class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length ==0)
			return null;

		int rootValue = preorder[0];
		TreeNode root = new TreeNode(rootValue);
		int index = -1; // root index in inOrder traversal
		for(int i=0; i<inorder.length; i++){
			if(inorder[i] == rootValue)
				index = i;
		}

		int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] preOrderRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		int[] InOrderLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] InOrderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

		root.left = buildTree(preOrderLeft, InOrderLeft);
		root.right = buildTree(preOrderRight, InOrderRight);

		return root;
	}
}