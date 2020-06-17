// Time Complexity : O(n)
// Space Complexity : O(h), h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Approach
//1) While traversing the root, compare two nodes of previous and root, if the value of root is greater than previous print false.
public class ValidBST {
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
	
	//Iterative
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null) return true;
    //     Stack<TreeNode> st = new Stack<>();
    //     TreeNode prev = null;
    //     while(root != null || !st.isEmpty()){
    //         while(root != null){
    //             st.push(root);
    //             root = root.left;
    //         }
    //         root = st.pop();
    //         if(prev!=null && prev.val >= root.val) return false;
    //         prev = root;
    //         root = root.right;
    //     }
    //     return true;
    // }
	
	//Recursive
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val, max);
    }

}
