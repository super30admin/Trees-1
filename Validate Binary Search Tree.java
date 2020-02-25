// Time Complexity :o(log n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
//Yes, As per my understanding this code should work but it is failing testcases

// Your code here along with comments explaining your approach
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
        int min= Integer.MIN_VALUE;
        int max= Integer.MAX_VALUE;
        return Validsearch(root,min,max);
    }
    public boolean Validsearch(TreeNode node,int minVal,int maxVal){
        if(node ==null){return true;}
        if(node.val >= minVal || node.val<= maxVal){
            return  Validsearch(node.left,minVal,node.val) && Validsearch(node.right,node.val,maxVal); 
 
        }
        else{         
            return false;   
        }      
    }
}