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
//Time Complexity: O(n)
//Space Complexity: O(n)
//Leetcode: 105. Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    
    HashMap<Integer,Integer> inorderIndex=new HashMap<>();
    //preorder-index
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        for(int i=0;i<n;i++)
        {
            inorderIndex.put(inorder[i],i);
        }
        
      
        return build(preorder,0,n-1);
        
        
    }
    public TreeNode build(int[] preorder, int start, int end)
    {
        // This is the current root index in inorder
        if(start>end)
            return null;
            
        TreeNode root= new TreeNode(preorder[index]);
        index++;
         int rIndex=inorderIndex.get(root.val);
        
        //form left-inorder array
        int lstart=start;
        int lend=rIndex-1;
         //form left-inorder array
        int rstart=rIndex+1;
        int rend=end;
      
        root.left=build(preorder,lstart,lend);
        root.right=build(preorder,rstart,rend);
        return root;
    }
}