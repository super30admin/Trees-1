// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    
    HashMap<Integer,Integer> map = new HashMap(); //can be accessed everywhere need not pass to 
    int preOrderIndex = 0;      //recursive function again n again
    
    public TreeNode buildTree(int[] preorder, int[] inorder)
    { 
        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i],i); //put element vs index of inorder
        }
        return helper(preorder,inorder,0,inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder,int[] inorder,int left,int right)
    {
        if(left > right)
            return null;
        
        TreeNode temp = new TreeNode(preorder[preOrderIndex++]);//as rootnode is first element of preorder arr
                         
        int inorderIndx = map.get(temp.val); //find position in inorder arr
        temp.left = helper(preorder,inorder,left,inorderIndx-1); //calculate for left elements of that position
        temp.right = helper(preorder,inorder,inorderIndx+1,right);//calculate for right elements of that position
        return temp;
    }
    
    
}