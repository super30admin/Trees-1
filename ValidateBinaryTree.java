// Time Complexity : O(n) where n is the nodes/vertices of the binary tree
// Space Complexity : O(n) since we're using recursion stack to traverse through all the nodes of the tree
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
Traverse through all the nodes of the tree i.e. left substucture and right substructure,
compare the limits of both left and right child with the root. If it does not satisfy the condition that left < root < right then return false.
If it satisfy till the leaf nodes, then return true.
*/


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
        return validate(root,null,null);
    }
    public boolean validate(TreeNode root,Integer left,Integer right){
        if(root == null) return true;
        if((left != null && left >= root.val) || (right != null && right <= root.val))
            return false;
        return validate(root.left,left,root.val) && validate(root.right,root.val,right);
    }
}
