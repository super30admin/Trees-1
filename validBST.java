//TC O(n) n is the number of nodes
//SC O(h) he is the height of the tree
//Did it run succrssfully on LeetCode: Yes

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

//Using limit based recurssion
//TC O(n) n is the number of nodes
//SCO (h) h is the height of the binary tree 
class Solution {
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root,null,null);
        return flag;
    }
    //using Integer instead of int since Integer is an object wrapper class 
    //which allows null values
    private void helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return;

        if(min != null && root.val <= min) flag = false;

        if(max != null && root.val >= max) flag = false;
        //logic
        helper(root.left, min, root.val);

        helper(root.right, root.val, max);

    }
}


//Using traversal based recurssion
//TC O(n) n is the number of nodes
//SC O(h) h is the height of the binary tree 
/** 
class Solution {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inOrder(root);
        return flag;
    }

//checking for valid BST using inOrder traversal 
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);

        //breach
        if(prev != null && prev.val >= root.val) flag = false;
        if(flag)
        prev = root;

        inOrder(root.right);
        // System.out.print("DOWN ");
        // System.out.println(root.val);
    }
}

 */