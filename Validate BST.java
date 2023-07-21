/*****************Validating the BST by traversing through the roots and checking if the follow the rules of BST*****************/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: When we traverse through the BST in inorder manner and print the root values, it should be printed in an ascending order. 
//To check if the values are in ascending order, we can maintain two pointers prev and curr.Curr is the root value and Prev is its child.
//For the left subtree, we need to check if the curr value is greater than the prev value. For the right subtree we check if the Curr value is lesser than the prev value.

/****Void Based Conditional Recursion****/

class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root)
    {
        //base
        if(root==null) return;
      //Logic
        //Left
        if(flag)
        {
            inorder(root.left);
        }
        
        if(prev!=null && prev.val>=root.val)
        {
            flag=false;
        }
prev=root;
        //Right
        if(flag)
        {
            inorder(root.right);
        }
       
    }
}



/****Boolean Based Recursion****/

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    
    }
    private boolean inorder(TreeNode root)
    {
        //base
        if(root==null) return true;
      //Logic
        //Left
         boolean left=inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
           return false;
        }
        prev=root;
        //Right
        boolean right=inorder(root.right);
        return left && right;
    }
}

/****Conditional Boolean Based Recursion****/

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    
    }
    private boolean inorder(TreeNode root)
    {
        //base
        if(root==null) return true;
      //Logic
        //Left
        if(inorder(root.left)==false) return false;
        if(prev!=null && prev.val>=root.val)
        {
           return false;
        }

        prev=root;

//It goes to the right only if left is true
        //Right
        return inorder(root.right);
    }
}








/******************Validating the BST by checking if the roots lie in the correct range they should be in*******************/
// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: //We need to traverse through the left and right side of the binary tree
//When we move towards the left, the minimum will remain the same and the maximum will be the value of the root, and when we are moving towards the right the maximum will remain the same and the minimum will be the value of the root.
//In the helper function we need to  pass the root, the minimum and the maximum, which is the range


/****Using Void Based Recursion****/

class Solution {
    boolean flag;
    
    public boolean isValidBST(TreeNode root) {
        this.flag=true; //default value of the flag
        helper(root,null,null);
        return flag;
    }
    private void helper(TreeNode root, Integer min, Integer max)
    {   
        //base
        if(root==null) return;

	  //Preorder        
	if(min!=null && min>=root.val) flag=false;
        if(max!=null && max<=root.val) flag=false;

	//Logic
        //Left
        if(flag)
        {
        helper(root.left,min,root.val);
        }
        //Right
        if(flag)
        {
        helper(root.right,root.val,max);
        }
        
    }
}



/****Using Boolean Based Recursion****/
class Solution {
  
    public boolean isValidBST(TreeNode root) 
    {
        return helper(root,null,null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max)
    {   
        //base
        if(root==null) return true;

        //Preorder
        if(min!=null && min>=root.val) return false;
        if(max!=null && max<=root.val) return false;
        //Logic
        //Left
        boolean left=helper(root.left,min,root.val);
        boolean right=helper(root.right,root.val,max);
        return left && right;
    }              
}
