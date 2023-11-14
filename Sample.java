// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
//Time Complexity -> O(n)
//Space Complexity -> O(h) where h -> height of binary Search Tree
//Validate BST
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
    //using 2nd Approx Based Recursion
    //postorder
    public boolean isValidBST(TreeNode root) {
        return inorder(root,null,null);
        
    }
    
         

    public boolean  inorder(TreeNode root,Integer min,Integer max){
         //base condition
         if(root==null) return true; //A null tree is always a BST
              
         

         
         boolean left = inorder(root.left,min,root.val);
          //check condition
         
           boolean  right = inorder(root.right,root.val,max);
            

        //Recursive call
         if(min!=null && root.val<=min){ //check for min value
             return false;
         }

         if(max!= null && root.val>=max){ //check for max 
             return false;
         }
         
         return left&&right;

    }
}

class Solution {
    //using 2nd Approx Based Recursion
    //preorder
    public boolean isValidBST(TreeNode root) {
        return inorder(root,null,null);
        
    }
    
         

    public boolean  inorder(TreeNode root,Integer min,Integer max){
         //base condition
         if(root==null) return true; //A null tree is always a BST
              
         //check condition
        if(min!=null && root.val<=min){ //check for min value
             return false;
         }

         if(max!= null && root.val>=max){ //check for max 
             return false;
         }
         
         boolean left = inorder(root.left,min,root.val);
          
         
           boolean  right = inorder(root.right,root.val,max);
            

        //Recursive call
         
         
         return left&&right;

    }
}
class Solution {
    //using 2nd Approx Based Recursion
    //inorder
    public boolean isValidBST(TreeNode root) {
        return inorder(root,null,null);
        
    }
    
         

    public boolean  inorder(TreeNode root,Integer min,Integer max){
         //base condition
         if(root==null) return true; //A null tree is always a BST
              
         //Recursive call

         
         boolean left = inorder(root.left,min,root.val);
          //check condition
         if(min!=null && root.val<=min){ //check for min value
             return false;
         }

         if(max!= null && root.val>=max){ //check for max 
             return false;
         }
         
        
           boolean  right = inorder(root.right,root.val,max);
            return left&&right;
         
         

    }
}

class Solution {
    //using Conditional Recursion
    //preorder
    TreeNode prev;
    boolean flag;
       
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
        
    }
    public void  inorder(TreeNode root){
         //base condition
         if(root==null) return; //A null tree is always a BST
              
         //Recursive call

         if(flag) inorder(root.left);
         

          //check condition
         if(prev!=null && prev.val>=root.val){
             flag = false;
         }
         
         
         prev = root; //After the left side is done we assign prev with the root and then right side is called;
            if(flag) inorder(root.right);
            
         
         return;

    }
}
class Solution {
    //using void Conditional Recursion
    //preorder
    TreeNode prev;
    boolean flag;
       
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
        
    }
    public void  inorder(TreeNode root){
         //base condition
         if(root==null) return; //A null tree is always a BST
              
         //Recursive call

         if(flag) inorder(root.left);
         

          //check condition
         if(prev!=null && prev.val>=root.val){
             flag = false;
         }
         
         
         prev = root; //After the left side is done we assign prev with the root and then right side is called;
            if(flag) inorder(root.right);
            
         
         return;

    }
}
class Solution {
    //using boolean Conditional Recursion
    TreeNode prev;
       
    public boolean isValidBST(TreeNode root) {
        return inorder(root); 
        
    }
    public boolean  inorder(TreeNode root){
         //base condition
         if(root==null) return true; //A null tree is always a BST
              
         //Recursive call

         boolean left = inorder(root.left);
         if(left == false) return false;
         

          //check condition
         if(prev!=null && prev.val>=root.val){
             return false;
         }
         
         
         prev = root; //After the left side is done we assign prev with the root and then right side is called;
            boolean right =  inorder(root.right);
            if(right == false) return false;
            
         
         return left && right;

    }
}

//root to leaf sum
//Time Complexity -> O(n)
//Space Complexity -> O(h)
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
    //USing update before calling
    int result;

    public int sumNumbers(TreeNode root) {
        int currNum = 0;
        helper(root,0);
        return result;
       
    }

    public void helper(TreeNode root,int currNum){

        //base Condition
        if(root==null){
            return;
        }

        currNum = currNum*10 + root.val;
        helper(root.left,currNum);
        if(root.left == null && root.right == null){ //if it is a leaf node then add the currNum to result
             result = result + currNum;

        }

        helper(root.right,currNum);
        
    }
}

class Solution {
    //USing update during  calling
    int result;

    public int sumNumbers(TreeNode root) {
        int currNum = 0;
        helper(root,0);
        return result;
       
    }

    public void helper(TreeNode root,int currNum){

        //base Condition
        if(root==null){
            return;
        }

        helper(root.left,currNum*10 + root.val);
        if(root.left == null && root.right == null){ //if it is a leaf node then add the currNum to result
             result = result + currNum*10 + root.val;

        }

        helper(root.right,currNum*10 + root.val);
        
    }
}