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
// time complexity 0(n)
// space complexity 0(n)
class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length==0 || inorder == null || inorder.length==0)
        {
            return null;
        }
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1);

    }
    private TreeNode helper(int[] preorder, int[]inorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        int rootval=preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootval);
        int rootidx=map.get(rootval);

        root.left=helper(preorder, inorder, start, rootidx-1);
        root.right=helper(preorder,inorder,rootidx+1,end);

        return root;

    }
}