//Problem 41 : Validate BST
// Time Complexity : O(N), N stands for number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Steps:
  Just pass max and min value for each node whenever traversing left side or right side of the bst. On right traversal of the bst, make sure left subtree elements are greater than the top root element and smaller than the parent root element.
  Example: Below while traversing right side of BST,on the left node which is 8, it should be greater than the top root which is 4 and smaller than the parent root which is 10.(8>4(min) && 8<10(max)).
  
              4
           3     10
         1      8   12

  Note : In the interview, ask interviewer about edge case whether all the nodes in the tree will be unique or not. If there will be duplicates, make sure to check equal to while checking greter or less than conditions. 
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

class Solution41 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        
        if(root==null){
            return false;
        }
        
        return checkValidity(root,null,null);
    }
    
    private boolean checkValidity(TreeNode root,Integer max, Integer min){
        
        //base
        if(root==null){
            return true;
        }
        
        if((max!=null && root.val>=max) || (min!=null && root.val<=min)){
            return false;
        }
           
        //logic
        boolean case1 = checkValidity(root.left,root.val,min);
        boolean case2 = checkValidity(root.right,max,root.val);
        
        return case1 && case2;
    }
    
}