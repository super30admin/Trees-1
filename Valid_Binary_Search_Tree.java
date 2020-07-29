import java.util.Stack;
//Approach: In itereative approach, am doing inorder traversal and whenever i visit the root, I check if its value is lesser than the previous node. 
//2. Am maintaining the prev node value in "prev" and all the nodes has been pushed onto stack. 
public class Valid_Binary_Search_Tree {
	public boolean isValidBST(TreeNode root) {
        //edge case
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root!= null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}
//Time Complexity : O(n) where n is the number of nodes in the tree
//Space Complexity : O(n) where n is the depth of the tree 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :


class Solution{
	//Approach: 1. Inorder is done recursively here, but maintaining the result and prev node in global scope.
	//2. While visiting the root in inorder traversal, am checking for the condition if new node value is lesser than the root value. 
	
	TreeNode prev = null;
    boolean result;
    public boolean isValidBST(TreeNode root) {
        //edge case
        
        if(root == null)
            return true;
        result = true;
        helper(root);
        return result;
    }
    private void helper(TreeNode root)
    {
        if(root == null)
            return;
        helper(root.left);
        
        if(prev != null && prev.val >= root.val) result = false;
        prev = root;
        helper(root.right);
    }
}
//Time Complexity : O(n) where n is the number of nodes in the tree
//Space Complexity : O(1)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
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