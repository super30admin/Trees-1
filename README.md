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


Time Complexity: O(h) where h is a height of the tree.

Space Complexity: O(1) but the recursive stack space complexity will be O(h).

Explanation of leetcode solution: 
We can validate if give tree is BST or not using inorder traversal. We will just need to check if previous node value is less than the current root node value as in inorder traversal everything will be in sorted order. There could be 4 solutions - void inorder traversal, condition void based inorder traversal, boolean based inorder traversal, boolean condition based inorder traversal. We will keep prev node as a global variable as we are changing it after completion of left side of the tree traversal. 



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
    TreeNode prev;
    // boolean flag;
    public boolean isValidBST(TreeNode root) {
        // this.flag = true;
        return inorder(root);
        // return flag;
    }

    // private void inorder(TreeNode root) {
    private boolean inorder(TreeNode root) {
        // base
        // if(!flag) return;

        if(root == null) {
            // return;
            return true;
        }

        // logic
        // inorder(root.left);
        boolean left = inorder(root.left);

        // if(prev != null && prev.val >= root.val) {
        //     flag = false;
        // }

        if(prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;

        // if (flag) {
            // inorder(root.right);
        // } 

        if(!left) return false;
            
        boolean right = inorder(root.right);

        return left && right;
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


Time Complexity: O(n) where n is number of nodes as each node will be processed once and hashmap operations such as insertion, lookups will take O(1) time.

Space Complexity: O(n) for the hashmap and for the recursive stack worst case scenario where n is number of nodes in the tree.

Explaination: First we will create a hashmap where we will store the indices of elements in the inorder array for quick access. Then we will use helper function to recursively construct the tree and we will utilize preorder array for root nodes and the inorder array to determine the subtree boundries. For each root node we will construct its left and right subtrees by slicing the inorder array accordingly.



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

    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) {
            return null;
        }

        // int rootVal = preorder[0];
        // TreeNode root = new TreeNode(rootVal);
        // int rootIdxInorder = -1;

        this.map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            // if(inorder[i] == rootVal) {
            //     rootIdxInorder = i;
            //     break;
            // }
            map.put(inorder[i], i);
        }

        // int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdxInorder);
        // int[] inorderRight = Arrays.copyOfRange(inorder, rootIdxInorder + 1, inorder.length);

        // int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length + 1);
        // int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length + 1, preorder.length);

        // root.left = buildTree(preorderLeft, inorderLeft);
        // root.right = buildTree(preorderRight, inorderRight);

        // return root;

        return helper(preorder, 0, inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int start, int end) {

        if(start > end) {
            return null;
        }

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);

        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }
}