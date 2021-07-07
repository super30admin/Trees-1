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

The idea is to use min and max across any node. By keeping initially min = INTEGER.MIN and max - INTGER.max.
The trick is also to check of nullable of Min and Max which was missing from my previous step.
**/


class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        boolean out = check(root,null,null);
     
        return out;
    }
    
    private boolean check(TreeNode root,Integer min, Integer max){
  
        if(root == null)
            return true;
        
        if (min != null && root.val <= min) 
            return  false;   
        
        if(max != null && root.val >= max)
            return false;    
            
        return check(root.left, min, root.val) &&check(root.right, root.val, max); 
        
        //return false;
    }
        
    
    }
    
