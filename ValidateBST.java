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
    Leetcode problem 98: Validate BST
    T.C: O(n) :: S.C: O(h) - recursive stack space equal to height of tree

    Solved using Recursive approach: For a BST to be valid the root's left child is
    smaller and right child is larger (for all the nodes in the tree). This would mean
    if we were to traverse the tree in inorder (L Root R) we would get the elements in
    a sorted order. Hence, we can perform an inorder traversal of the given TreeNode
    and optimize the space complexity by only checking if the prev element which was 
    traversed is smaller the current element. If the entire tree is traversed without a
    breach then return true else return false!
*/

class Solution {
    TreeNode prev;
    //boolean isValid;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        //isValid = true;
        
        return inorder(root);

        //return isValid;
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (inorder(root.left) == false) return false;
        //System.out.println("Up \n" + root.val);

        if (prev != null && prev.val >= root.val) {
            //isValid = false;
            return false;
        } else {
            prev = root;
        }

        return inorder(root.right);      
    }
}