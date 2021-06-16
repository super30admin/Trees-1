# Trees-1

## Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


## Solution 1 for Problem 1

// Time Complexity = O(n) //we will touch each node once
// Space Complexity = O(h) //height of the tree
class Solution {
    
    boolean result;
    TreeNode prev=null; 
    
    public boolean isValidBST(TreeNode root) {  
        result= true; 
        inorder(root);
        return result;  
    }
    
    private void inorder(TreeNode root)
    {
        if(root==null) return; //base case
        
        inorder(root.left);  //left inorder
        
        if(prev!=null && prev.val>=root.val){
            result=false;
            return;
        }
        
        prev=root;
        
        inorder(root.right); //inorder right
    }
}


## Solution 2 of Problem 1

// Time Complexity = O(n) //we will touch each node once
// Space Complexity = O(h) //height of the tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return helper(root,null,null); //initially the min and max of the root is null and null 
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        //base
        
        if(root==null) return true; 
        
        if(min != null && root.val <= min) return false; //if the root's value is less than the min, return false
        if(max != null && root.val >= max) return false; //if the root's value is greater than the max, return false
        
        boolean case1 = helper(root.left, min, root.val); //inorder left 
        
        boolean case2 = helper(root.right, root.val, max); //inorder right
        
        return case1 && case2; //return the logical and of both the cases
    }
}

## Solution 3 for Problem 1

// Time Complexity = O(n) //we will touch each node once
// Space Complexity = O(h) //height of the tree

    public boolean isValidBST(TreeNode root) {
        
         Stack<TreeNode> myStack = new Stack<>(); 
         TreeNode prev = null; 
           while(root!=null || !myStack.isEmpty())
            {
               //inorder left
                while(root!=null)
                {
                    myStack.push(root);
                    root=root.left; 
                }
            
                root=myStack.pop(); 
                //check if the prev value is greater, return false
                if(prev!=null && prev.val>=root.val) return false;
                prev=root;
                //inorder right
                root= root.right; 
            }
        
            return true;

## Problem 2

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7


## Solution 

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 ) return null;  //if the null is empty return null 
        int val = preorder[0]; //calculate the root node
        
        TreeNode root = new TreeNode(val); //create a node
        int rootIndex = 0;
        
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == val)
            {
                rootIndex = i; //find the root node index in the inorder traversal
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndex+1); //the left of the tree will be the 1 to rootindex since preorder traversal 
        int[] preRight = Arrays.copyOfRange(preorder, rootIndex+1, preorder.length); // right will be rootindex+1 to end since preorder traversal
        int[] inLeft = Arrays.copyOfRange(inorder, 0 , rootIndex); // the left will be 0 to rootindex-1 since inorder traversal
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length); //the right will be rootindex+1 till end since inorder traversal
        
        root.left = buildTree(preLeft, inLeft); //build tree recursively 
        root.right = buildTree(preRight, inRight); 
        
        return root; 
    }
}