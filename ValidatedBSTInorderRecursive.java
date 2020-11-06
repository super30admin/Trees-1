package binaryTrees;
/**
 * Tip: Inorder Traversal of a BST must return a sorted order of elements
 * Approach: Inorder traversal performed using recursion
 * Time: O(n)
 * Space: O(1) excluding stack space
 * Leetcode Accepted: yes
 * Problems faced: No
 *
 */
public class ValidatedBSTInorderRecursive {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2); 
        root.left = new TreeNode(1); 
        root.right = new TreeNode(3); 
        System.out.println(isValidBST(root));
	}
	//prev is declared as data variable in order to let it available through out the left subtree, root node and right subtree
	private static Integer prev;
    public static boolean isValidBST(TreeNode root) {
        prev = null;
		return helper(root);
    }
	    
    private static boolean helper(TreeNode root) {
		if(root == null) return true;
		//Check with left sub tree
        if(!helper(root.left)) return false;
        //At the parent node
		if(prev != null && prev >= root.val) {
			return false;
		}
        prev = root.val;
        //Check with right sub tree
        if(!helper(root.right)) return false;
        return true;
	}

}
