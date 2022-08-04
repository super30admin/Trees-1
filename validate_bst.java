//Time Complexity - O(n)
//Space Complexity- O(1)


//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
import java.util.*;
class Solution {
    public boolean isValidBST(TreeNode root) {
        long min=Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        return isValid(root,min,max);
        
    }
    
    public boolean isValid(TreeNode root, long min, long max){
        if(root==null)
            return true;
        if(root.val <min || root.val>max)
            return false;
        if((root.val>min && root.val<max))
            return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
        return false;
    }
}
