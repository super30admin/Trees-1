package Tree1;

import java.util.Stack;

/*S30 Big N Problem #41 {Medium} - https://www.youtube.com/watch?v=mwzKeVZmRik
   
    You are given a binary tree, and you have to check whether its a binary search tree or not.
    you may assume that BST can be defined as follows: 

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:

       5
       / \
      1   4
         / \
        3   6
   
        Input: [5,1,4,null,null,3,6]
        Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.
    Source Link: https://leetcode.com/problems/validate-binary-search-tree/
        -------------------------------------------------------------------------------------------------------
        Time complexity : o(m+n) 
        space complexity: o(1) 
        Did this code run successfully in leetcode : yes
        problems faces : no
        */

public class ValidBSTIterative {

    TreeNode prev;

    public boolean isValidBSTWithIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode prev = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) //left recursive call
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (prev != null && prev.val >= root.val)
                return false;

            prev = root;
            root = root.right;
        }

        return true;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
