import java.util.Arrays;


//idea:  recrusive solution.
//preorder means root left right and inorder means left root right .
//therefore first element in preorder is root of BST. WE will search this root in inorder to find its left and right element .
//so in inorder once root element is found then all  element to its left are left of root and all element to its right are right of root
//time complexity o(n)
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:yes
public class BuildBSTUsingPreAndInOrder {
	
	 static  class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	       int len = preorder.length;
	       // final recursion
	       if(len == 0) return null;
	       TreeNode root = new TreeNode(preorder[0]);
	       if(len == 1) return root;
	       //we use L to divide the tree into left & right
	       int L = 0;
	       for(int i = 0; i < len;i++){
	           if(inorder[i] == preorder[0])
	               L = i;
	       }
	       root.left = buildTree(Arrays.copyOfRange(preorder,1,L+1),Arrays.copyOfRange(inorder,0,L));
	       root.right = buildTree(Arrays.copyOfRange(preorder,L+1,len),Arrays.copyOfRange(inorder,L+1,len));
	       return root;
	   }
	 /* This funtcion is here just to test buildTree() */
    static void printInorder(TreeNode node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.val + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
	
	 // driver program to test above functions 
    public static void main(String args[]) 
    { 
       
        int in[] = new int[] { 9,3,15,20,7}; 
        int pre[] = new int[] { 3,9,20,15,7 }; 
        int len = in.length; 
        TreeNode root =buildTree(in, pre);
  
        // building the tree by printing inorder traversal 
        System.out.println("Inorder traversal of constructed tree is : "); 
        printInorder(root); 
    } 
}
