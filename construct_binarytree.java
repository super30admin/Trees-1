//TC: O(n)
//SC: O(1)
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
    int idx;
    public TreeNode helper( HashMap<Integer,Integer> map,int start, int end,int root,int[] preorder)
    {
        if(start>end)
        return null;
        int rootVal=preorder[idx];
        idx++;
        root=map.get(rootVal);
        TreeNode rt=new TreeNode(rootVal);
         rt.left=helper(map,start,root-1,root,preorder);
         rt.right=helper(map,root+1,end,root,preorder);
         return rt;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(map,0,inorder.length-1,-1,preorder);
        
    }
}