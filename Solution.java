// Time Complexity: O(n)
// Space Complexity: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);           
    }
    
    public boolean isValid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        
        if(node.val > min && node.val < max){
            return (isValid(node.left, min, node.val) && isValid(node.right, node.val, max));
        }
        else{
            return false;
        }
    }
}
