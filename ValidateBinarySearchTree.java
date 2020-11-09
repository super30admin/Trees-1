// Time Complexity : O(n) where m=no. of nodes in the tree
// Space Complexity : O(H) Where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We will be using recursion techniques to solve the problem. We will be visiting the each node and maintaining the
 * current sum to that node from the root and list of the nodes from the root to that node.
 * To optimize the solution, we will use backtracking approach to update the list which avoids in creating
 * new list at each node improving time and space complexity
 * */


import java.util.Stack;

/**
 * Definition for a binary tree node.
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {

    TreeNode prev;

    //Using recursive method
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root){
        //base
        if(root==null) {
            return true;
        }
        if(inOrder(root.left)==false) {
            return false;
        }
        //inOrder(root.left);
        if(prev!=null && prev.val>=root.val) {
            return false;
        }
        prev = root;
        return inOrder(root.right);
    }

    //Using iterative method
     /*public boolean isValidBST1(TreeNode root){

         TreeNode prev1 = null;
         Stack<TreeNode> s = new Stack<>();

         while(root!=null || !s.isEmpty()){
             while (root!=null){
                 s.push(root);
                 root=root.left;
             }
             root=s.pop();
             if(prev1!=null && prev1.val>=root.val) return false;
             prev1=root;
             root=root.right;
         }
         return true;
     }*/
}
