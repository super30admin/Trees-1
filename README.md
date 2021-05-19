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

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        return helper(root);
        
    }
    private boolean helper(TreeNode root)
    {
        if(root==null)
            return true;
     //searching in left subtree weather its bst are not 
        if(helper(root.left)== false) return false;
        System.out.println(root.val);
      // cheching with root elements and changeing the prevous to root 
        if(prev!= null && prev.val >= root.val) return false;
        prev=root;
       //traversal to right 
        return helper(root.right);
    }

}
TIME Complexity :O(n),n is the total number of elements in the tree
Space Complexity:O(h) height of the tree

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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int idx=-1;
        int rootVal=preorder[0];
        TreeNode root= new TreeNode(rootVal);
        //finding root element int the inorder array assiging idex to it 
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)
            {
            idx=i;
            break;
            }
              
        }
        //slicing array using idx and passing as new array
        int[] preleft=Arrays.copyOfRange(preorder,1,idx+1);
        int[] preright=Arrays.copyOfRange(preorder,idx+1,preorder.length);
        int[] inleft=Arrays.copyOfRange(inorder,0,idx);
        int[] inright=Arrays.copyOfRange(inorder,idx+1,inorder.length);
        root.left=buildTree(preleft,inleft);
        root.right=buildTree(preright,inright);
        return root;
        
            
        
        
    }
}
TIME COMPLEXITY :O(n^2)
SPACE COMPLEXITY :O(n^2)
NO ERRORS WHILE EXECUTING .
