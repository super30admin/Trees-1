/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*Algorithm 
    Recursive Solution:
     1. We will traverse through the whole of Binary Tree, For each node we compare the value of the node with minimum and maximum allowed for that node. If at any point the condition is not satisfied then we return false.
     2. When we go to the left, the min will be previous min and the max will be root val of the respective node.
     3.When we go to the right, the max will be previous max and the min will be the root val of the respective node.
     
     
     Time Complexity: O(n)
     Space Complexity: O(1)
    
    Did the code run on leetcode? Yes
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        //Base Case
        
        if(root==null) return true;
        
        if((min!=null && root.val<=min) || (max!=null && root.val>=max))return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}