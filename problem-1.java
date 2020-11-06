/**
 * Q. Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Approach - We use the concept of BST - traversing a BST inorder get all node value 
 * in ascending order. Hence we travel the BST using inorder treversal and check wheather
 * all elements are sorted. 
 * 
 * Time Complexity - O(n) Space Complexity - O(1)
 */

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root != null){
            if(!isValidBST(root.left)){
                return false;
            }

            //If previous value is larger than current value
            //then it voilates BST property. 
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            if(!isValidBST(root.right)){
                return false;
            }
        }
        return true;
    }
}