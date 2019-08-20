package binaryTrees;
/**
 * Approach: Determining the range of values for each node
 * Root: Range can be between null and null
 * Left: Range is between parents'min and value of parent
 * Right: Range is between value of parent and parent's max
 * Time: O(n)
 * Space: O(1)
 * Leetcode accepted: yes
 */
public class validateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2); 
        root.left = new TreeNode(1); 
        root.right = new TreeNode(3); 
        System.out.println(isValidBST(root));

	}

	private static boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	private static boolean helper(TreeNode root, Integer min, Integer max) {
		//base case: Root reaches null, by skipping all possibilities of  false conditions
		if(root == null) return true;
		//If root value does not fall in the range of the node
		if(min != null && root.val <= min) return false;
		if(max != null && root.val >= max) return false;
		
		//Only if both children of a node satisfy BST conditions
		return helper(root.left, min, root.val)  && helper(root.right, root.val, max);
	}

}
