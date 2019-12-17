/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to use min and max across any node. By keeping initially min = INTEGER.MIN and max - INTGER.max

**/

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null)
            return true;
          
        boolean out = check(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
     
        return out;
    }
    
    private boolean check(TreeNode root, int min, int max){
        
        if (root == null) 
            return true; 
  
        if (root.val < min || root.val > max) 
            return false; 
   
        return (check(root.left, min, root.val-1) && 
                check(root.right, root.val+1, max)); 
        
        
        }
    
    }
    
