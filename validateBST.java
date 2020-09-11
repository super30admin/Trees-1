    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/validate-binary-search-tree/
    Time Complexity for operators : o(n) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(n) ... recursive stack in case of recusrin and normal stack for iterative 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Traverse Inorder and store it in array. And then check whether it is sorted or not.

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
            # 1st one - Recursive Approach
                    A. create function and pass root and lower and upper bound
                    B. if lower > = val or upper<=val return false
                    C. Make recursive call to left side with lower and value passed to it
                    D. Make recursive call to left side with val and upper passed to it
              2md One - Iterative approach
                    A. If Inroder traversal of BST considered then it will be in order sorted.
                        then just check previous value with current everytime.
                    B. Add the all left side into stack and pop one by one and do the comparison prev.val >= root.val.
                    C. After comparision make previous to current (root)
                    D. move to the right now.
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

   class validateBST {

    public static void isValid(TreeNode root){//,Integer lower, Integer upper) {
        
       
        //recursive approach
//         if(root==null) 
//             return true;       
        
//         int val = root.val;
        
//         if(lower!=null && lower >= val) 
//             return false;
//         if(upper!=null && upper <= val) 
//             return false;

//         return (validateBST(root.right,val,upper) && validateBST(root.left,lower,val));  
        
        //inorder with comparing prev element. inorder BST is in sorter order
        
        if(root==null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root!=null){
            
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(prev != null && prev.val >= root.val)
                return false;
            
            prev = root;
            
            root = root.right;
            
        }
        
        return true;
    }
}