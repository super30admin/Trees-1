// Time Complexity : O(
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBST {

       // Iterative Solution
       public boolean isValidBSTIterative(TreeNode root) {
           Stack<TreeNode> stack = new Stack<>();
           TreeNode prev = null;

           // while root is not null - keep going left
           while(root != null || !stack.isEmpty()){
               while(root != null){
                   stack.push(root);
                   root = root.left;
               }

               root = stack.pop();


               if(prev != null && prev.val >= root.val){
                   return false;
               }
               prev = root;

               root = root.right;
           }

           return true;
       }

       // Recursive with one global variable
    TreeNode prev = null;
    public boolean isValidBSTRecursive(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root){
        // Base Case
        if(root == null){
            return true;
        }


        if(inorder(root.left) == false){
            return false;
        }

        if(prev != null && prev.val >= root.val){
            return false;
        }

        prev = root;
        return inorder(root.right);
    }

    // Recursive final
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        // base case
        if(root == null){
            return true;
        }

        if((max != null && root.val >= max )||(min != null && root.val <= min)){
            return false;
        }
        // logic
        return helper(root.left, min, root.val) && helper(root.right,root.val, max);
    }
}
