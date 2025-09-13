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

/*
* Property of a BST: if traveresed in inorder, the list will be sorted. 
* prev_node is a datastructure in a datastructure
* Do an in order traversal, so all the nodes should be in increasing order, if prev node is greater than current node, that means there is a breach and its not a valid BST
There are four ways of solving this problem using recursion. 
1. Void based recursion - bruteforce
2. Boolean based recursion - bruteforce
3. Void based conditional recursion where you stop as soon you find the breach and dont process any further nodes
4. Boolean based conditional recursion
*/

// TC:O(n) -> n nodes to iterate - same SC for all four solutions
// SC:O(h) -> (height of the tree)at most h elements will be in recursive stack - worst case can be O(N) - same SC for all four solutions
class Solution {
    //flag to store the result and prev node to do the comparison
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        // helper(root);
        // return flag;
        return helper(root);
        
    }

    // boolean based conditional recursion

    private boolean helper(TreeNode root){
        //base
        if(root == null)
            return true;
        //logic

        boolean l = helper(root.left);

        if(prev != null && prev.val >= root.val)
            return false;
        
        prev = root;
        boolean r = helper(root.right);

        return l && r;
    }

    //void based conditional recursion

    // private void helper(TreeNode root){
    //     //base
    //     if(root == null)
    //         return;
    //     //logic

    //     helper(root.left);
    //     if(prev != null && prev.val >= root.val){
    //         flag = false;
    //         return;
    //     }
    //     prev = root;
    //     helper(root.right);
    // }

    // // void based recursion 
    // private void helper(TreeNode root){
    //     //base
    //     if(root == null)
    //         return;

    //     //logic

    //     helper(root.left);

    //     if(prev != null && prev.val >= root.val)
    //         flag = false;
        
    //     prev = root;

    //     helper(root.right);

    // }
}