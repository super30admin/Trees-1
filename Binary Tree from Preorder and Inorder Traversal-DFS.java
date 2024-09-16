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
 
// Time complexity=O(n^2)
// Space Complexity=O(n)
class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	return helper(preorder,inorder, 0, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int preIndex, int start,int end)
    {
        if(preIndex>preorder.length-1 || start>end) return null;
        TreeNode root= new TreeNode(preorder[preIndex]);
        int index=0; 
        for(int i=start;i<=end;i++)
        {
            if(preorder[preIndex]==inorder[i])
                index=i;
        }
        
        root.left = helper(preorder,inorder, preIndex+1, start ,index-1);
        root.right=helper(preorder,inorder, preIndex+index-start+1, index+1 ,end);
        return root;
    }
        
}