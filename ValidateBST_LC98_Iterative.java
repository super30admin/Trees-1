//@Validating BST Iterative solution 
//Time complexity O(N), Space complexity O(H), where H is the height of the tree

package ValidateBST_LC98;

import java.util.Stack;

public class ValidateBST_LC98 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode(int x) 
	     { 
	    	 val = x; 
	    	 }
	     
	 }
	static TreeNode root; 

	 public boolean isValidBST(TreeNode root) {
         if(root == null)
        {
            return true;
        }
        
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        
       
        while(root!=null || !st.isEmpty())
        {
            while(root!=null){
                st.push(root);
                root = root.left;
        }
        root = st.pop();
        if(prev !=null && root.val <= prev.val)
        {
            return false;
        }
        
        prev = root;
        root = root.right;
      }
        
    return true;
	 }
	public static void main(String[] args) {
		ValidateBST_LC98 tree = new ValidateBST_LC98(); 
    tree.root = new TreeNode(4); 
    tree.root.left = new TreeNode(2); 
    tree.root.right = new TreeNode(5); 
    tree.root.left.left = new TreeNode(1); 
    tree.root.left.right = new TreeNode(3); 

    if (tree.isValidBST(root)) 
        System.out.println("IS BST"); 
    else
        System.out.println("Not a BST"); 
		// TODO Auto-generated method stub

	}

}
