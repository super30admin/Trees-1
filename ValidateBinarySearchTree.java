import javax.swing.tree.TreeNode;
import java.util.Stack;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Getting started and determining if inorder, preorder or post order should be used.

// Your code here along with comments explaining your approach

public class ValidateBinarySearchTree {


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
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();


            Integer prev = null;

            while(!stack.isEmpty() || root != null ){
                //loop and add left side to stack
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }

                //check is root is less than left and reutrn false if true
                root = stack.pop();
                if(prev!= null && root.val <= prev) return false;
                prev = root.val;
                root = root.right;
            }
            return true;
        }
    }
}
