/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     //Store the prev node in prev
        TreeNode prev;
        Boolean flag; 
    
    public boolean isValidBST(TreeNode root) {
        //Set default Flag = true
        flag=true;
        //calling inOrder func
        inOrder(root);
		return flag;
		
	} 
	
	private void inOrder(TreeNode root) {
		
		if (root == null) return;
		//recursively calls until left leaf is found
		inOrder(root.left);
		
        //check if the leaf(prev) node is not null and leaf(prev)> root then it is a breach
        if (prev != null && prev.val >= root.val) 
            flag = false;
        
        prev=root;
        //if flag is true only then call the right recursive tree
        if (flag)
		    inOrder(root.right);
		
		
	}
	
        
}