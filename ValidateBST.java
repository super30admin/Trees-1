// Time Complexity : O(n); where n is number of nodes in tree
// Space Complexity : O(H); where H is tree height
class ValidateBST{
	static class TreeNode {
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
	public boolean isValidBST(TreeNode root) {
		//Traverse the BST in recursive manner 
		return validate(root,null,null);
	}
	private boolean validate(TreeNode root, Integer min, Integer max) {
		if (root==null) return true;
		if ((min!=null && root.val<=min) || (max!=null && root.val>=max)) return false;
		
		//valid BST = min<root.left<root.val and root.val<root.right<max		
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}
	
	//Driver Code
	public static void main(String[] args) {
		ValidateBST ob = new ValidateBST();
		TreeNode node= new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
		System.out.println("Is valid BST: "+ ob.isValidBST(node));
	}
}