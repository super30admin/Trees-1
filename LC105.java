//Time Complexity : O(n)
//Time Complexity : O(1)

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        if(preorder == null || preorder.length==0)
        {
            return null;
        }
        
        
        
        int rootval = preorder[0];
        
        TreeNode root = new TreeNode(rootval);
        
        int root_index = -1;
        
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootval)
            {
                root_index = i;
            }
        }
        
        
        
        int inorder_left[] = Arrays.copyOfRange(inorder,0,root_index);
        int inorder_right[] = Arrays.copyOfRange(inorder,root_index+1,inorder.length);
        int preorder_left[] = Arrays.copyOfRange(preorder,1,root_index+1);
        int preorder_right[] = Arrays.copyOfRange(preorder,root_index+1,preorder.length);
        
        root.left = buildTree(preorder_left,inorder_left);
        root.right = buildTree(preorder_right,inorder_right);
        
        return root;
    }
}