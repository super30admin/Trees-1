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



## Solution 1 :
## Time Complexity:O(n) Space Complexity:O(h)
## We store the global previous pointer to store the previous accesed element to compare if root is smaller for left from its previous.
## If next root is larger from the right most previous of the subtree.

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
    private TreeNode prev = null; // Keeps track of the previously visited node during in-order traversal

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true; // An empty tree is a valid BST

        // Check the left subtree
        if (!helper(root.left)) return false;

        // Ensure the current node value is greater than the previous node value
        if (prev != null && root.val <= prev.val) return false;
        prev = root; // Update the previous node to the current node

        // Check the right subtree
        return helper(root.right);
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


## Solution 2 
## Time Complexity:O(n) Space Complexity:O(n)
## We are making a hashmap to store the index and pointers for the left as well as right subtree so that we can compare the root through
## preorder array find the index through hashmap and use the pointers for its left and right subtree.
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
    HashMap<Integer,Integer> map;
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      this.map=new HashMap<>();
      this.idx=0;
      for(int i=0;i<inorder.length;i++)
      {
        map.put(inorder[i],i);
      }
      return helper(preorder,0,inorder.length-1);  
    }

    private TreeNode helper(int[] preorder,int start,int end){
      if(start>end) return null;

      int rootVal=preorder[idx];
      idx++;

      int rootIdx=map.get(rootVal);
      TreeNode root=new TreeNode(rootVal);
      

      root.left=helper(preorder,start,rootIdx-1);
      root.right=helper(preorder,rootIdx+1,end);
      
      return root;
    }
}