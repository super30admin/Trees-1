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
    //TC O(n) SCO(1)
    TreeNode prev = null;
    boolean isValid = false;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
//         TreeNode prev = null;
//         Stack<TreeNode> s = new Stack<>();
//         while(root!=null || !s.isEmpty()){
//             while(root != null){
//                 s.push(root);
//                 root = root.left;
//             }
            
//             root = s.pop();
//             if(prev != null && prev.val >= root.val) return false;
//             prev = root;
//             System.out.println(root.val);
//             root = root.right;
            
//         }
       isValid = true; 
       Inorder(root); 
       return isValid; 
    }
    
    private void Inorder(TreeNode root){
        
        if(root == null) return;
        Inorder(root.left);
        if(prev != null && prev.val>= root.val){
            isValid = false;
            return;
        }
        prev = root;
        System.out.println(root.val);
        Inorder(root.right);

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

    //TC O(n) SC O(1)
    class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length ==0) return null;
        
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx= -1;
        
        for(int i =0; i< inorder.length;i++)
        {
            if(rootVal == inorder[i])
            {
                rootIdx =i;
                break;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder , 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder , rootIdx+1,inorder.length);
        int[] preorderLeft= Arrays.copyOfRange(preorder , 1, 1+rootIdx);
        int[] preorderRight = Arrays.copyOfRange(preorder , rootIdx+1,preorder.length) ;
        
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
        
    }
}
