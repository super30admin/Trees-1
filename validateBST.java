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

 //The isValidBST method calls validate(root, Long.MIN_VALUE, Long.MAX_VALUE), which checks if node.val lies strictly between min and max.
//It recursively updates the range for left (max = node.val) and right (min = node.val) subtrees to ensure all nodes follow BST rules.
//Time complexity: O(n)
//Space complexity: O(n)

class Solution { 
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }

    public boolean validate(TreeNode node, long min, long max)
    {
        if(node==null) return true;

        if(node.val<=min || node.val>=max) return false;

        //now check for the subtrees

        boolean leftSubtree= validate(node.left,min,node.val);
        boolean rightSubtree= validate(node.right,node.val,max);

        return leftSubtree && rightSubtree;

    }
}
