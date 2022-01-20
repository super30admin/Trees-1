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

// Time Complexity : O(N)
// Space Complexity : O(H) - height of the tree
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
//Recursive Inorder traversal

class Solution {
    boolean flagged = true;
    Integer prev;

    private void recursiveInorder(TreeNode root)
    {
        if(root == null) return;
        recursiveInorder( root.left);
        if(prev != null && prev >= root.val) 
        {
            flagged = false;
        }
        prev = root.val;
        recursiveInorder( root.right);
        
    }
    private boolean preorderDFS(TreeNode root, Integer min, Integer max)
    {
       if ( root == null) return true;
        
        if((min != null) && root.val <=min ||  (max!= null) && root.val >= max)
        {
            return false;
        }
        return preorderDFS(root.left, min, root.val) && preorderDFS(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
       /* boolean b= preorderDFS( root,null,null);
        return b;*/
        recursiveInorder(root);     
        this.prev = null;
        return this.flagged;
    }
}

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
// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
//Approach 1:
class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null
        
        if(preorder == null || preorder.length ==0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex =-1;
        //find idx of the root 
        for(int i=0; i< preorder.length ; i++)
        {
            if(rootVal == inorder[i])
            {
                rootIndex =i;
                break;
            }
        }
        
        //decide on left and right pointers 
        int[] inLeft = Arrays.copyOfRange(inorder,0, rootIndex );
        int[] preLeft =Arrays.copyOfRange(preorder, 1, rootIndex+ 1);
        int[] inRight = Arrays.copyOfRange(inorder,rootIndex+1, inorder.length );
        int[] preRight =Arrays.copyOfRange(preorder,rootIndex+1, preorder.length );
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
        
        
    }
}

//Approach 2:
class Solution {
    HashMap<Integer, Integer> map;
    int idx; 
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        //base case
        if(start> end) return null;
        //recursion
        
        int rootVal = preorder[idx];
        idx++;
        int rootIndexInorder = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, start, rootIndexInorder-1 );
        root.right = helper(preorder, inorder, rootIndexInorder +1, end);
        
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i=0; i < inorder.length ; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length -1);
    }
}
