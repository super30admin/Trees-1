// Time Complexity : O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use a pointer to keep a track of prev node and check if it's value is less than current root value.
 * If anywhere we get prev node value >= current node's value we return false.
 * So whenever pop happens, we check if prev is less and update prev = root for further checks
 * We keep class variable ans as boolean. Anywhere we get prev.val >= root.val we update it to false
 * At the end we return ans value
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
    TreeNode prev;
    boolean ans;
    public boolean isValidBST(TreeNode root) {
        ans = true;
        check(root);
        return ans;
    }
    
    private void check(TreeNode root){
        //base
        if(root == null)return;
        
        check(root.left);
        if(prev != null && prev.val >= root.val){
            ans = false;
            return;
        }
        prev = root;
        check(root.right);
    }
}