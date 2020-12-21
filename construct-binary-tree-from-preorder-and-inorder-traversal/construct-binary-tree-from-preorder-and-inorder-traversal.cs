/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    Dictionary<int,int> dict = new Dictionary<int,int>();
    int preindex=0;
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        int idx =0;
        foreach(int i in inorder)
        {
            dict.Add(i,idx++);
        }
        
        return helper(0,inorder.Length,preorder,inorder);
        
    }
    
    public TreeNode helper(int left,int right,int[] preorder,int[] inorder)
    {
        if(left==right)
        {
            return null;
        }
        
        int root_val = preorder[preindex];
        TreeNode root = new TreeNode(root_val);
        
        int index = dict[root_val];
        
        preindex++;
        root.left  = helper(left,index,preorder,inorder);
        root.right = helper(index+1,right,preorder,inorder);
        return root;
    }
}
