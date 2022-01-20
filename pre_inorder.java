public class pre_inorder {
}
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
Time:O(n);
 Space:O(n);

class Solution {
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1);

    }

    public TreeNode helper(int[] preorder,int[]inorder,int start,int end){
        // System.out.println("idx = "+idx + " start = "+start +" end = "+end);
        if(start>end){
            return null;
        }


        int index=hm.get(preorder[idx]);
        TreeNode node=new TreeNode(preorder[idx]);
        idx=idx+1;
        node.left = helper(preorder,inorder,start,index-1);

        node.right=helper(preorder,inorder,index+1,end);

        return node;

    }
}