/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if(preorder.Length == 0) return null;
        var rootVal = preorder[0];
        var rootIdx = -1;
        var root = new TreeNode(rootVal);
        for(int i = 0; i< inorder.Length; i++)
        { 
            if(inorder[i] == rootVal)
            {
                rootIdx = i;
                break;
            }
        }           
        
        int[] inleft = new int[rootIdx];
        Array.Copy(inorder, 0, inleft, 0, rootIdx);
        int[] inright = new int[inorder.Length - (rootIdx +1)];
        Array.Copy(inorder, rootIdx + 1, inright, 0, inorder.Length - (rootIdx +1));
        int[] preleft = new int[inleft.Length];
        Array.Copy(preorder, 1, preleft, 0, inleft.Length);
        int[] preright = new int[preorder.Length -1 - preleft.Length];
        Array.Copy(preorder, preleft.Length + 1, preright, 0, preorder.Length -1 - preleft.Length);

        root.left = BuildTree(preleft, inleft);
        root.right = BuildTree(preright, inright);

        return root;        
    }
}
