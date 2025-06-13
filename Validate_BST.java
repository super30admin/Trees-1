//T.C: O(n) n:elements in the tree
//S.c: O(h) Function stack of height of the tree.

/*Approach: initialize my min and max valu to minmum and maximum. I took long because it could handle the int range.
do recursive call to my helper function and pass the min and mx value to it. each call i will check if my root val is <= min and >= max then i will return false.
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
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        
        return helper(root, min, max);
    }
    

    private boolean helper(TreeNode root, long min, long max){
        //base
        if(root == null) return true;

        //logic
        if(root.val <= min || root.val >= max) return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}