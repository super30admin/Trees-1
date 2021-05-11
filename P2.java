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
//time- O(n)
//space- o(h)-h->height of tree
//passed in leetcode- yes

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        int currSum=0;
        helper(root, currSum);
        return result;
    }
    
    public void helper(TreeNode root, int currSum)
    {
        if(root==null) return;
        
        currSum= currSum*10+root.val; //gets updated in call stack
        System.out.println("root.val");
        System.out.println(root.val);        
        System.out.println("Currsum");
        System.out.println(currSum);
        helper(root.left,currSum);//recursive call
        
        //when we return from left child recursive call, we check if current node is leaf , and add curr sum to result
        if(root.left==null && root.right==null)
        {
            result+=currSum;
            System.out.println(result);
            
        }
        System.out.println(root.val);
        System.out.println(currSum);
        helper(root.right,currSum);//after we return from the right child , current node is also returned 
    }
    
    /*
    Recursive function with Int returntype
    
    public int helper(TreeNode root, int currSum )
    {
        if(root==null) return 0;;
         if(root.left==null && root.right==null)
        {
            return (currSum*10+root.val); since we didnt already add current node val to currSum 
                        
        }
        currSum= currSum*10+root.val; //gets updated in call stack
        int leftSubtreeSum= helper(root.left, currSum);        
        int rightSubtreeSum= helper(root.right, currSum);     
       
        return leftSubtreeSum+rightSubtreeSum; 
    }
    */
}