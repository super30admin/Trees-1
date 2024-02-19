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
    Dictionary<int, int> inorderMap = new Dictionary<int, int>();
    int idx = 0;
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.Length; i++) {
            this.inorderMap.Add(inorder[i],i);
        }
       
        return BuildNode(preorder, 0, inorder.Length - 1);


    }

    private TreeNode BuildNode(int[] preorder, int start, int end) {
        //base
        if(start > end) return null;

        int rootVal = preorder[idx];
        idx++;
        int rootIndex = inorderMap[rootVal];
        TreeNode root = new TreeNode(rootVal);
        root.left = BuildNode(preorder, start, rootIndex - 1);

        root.right = BuildNode(preorder, rootIndex + 1, end);
        return root;
    }
}