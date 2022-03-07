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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    class BSTPair{
        long min;
        long max;
        boolean isBST;
    }
    public boolean isValidBST(TreeNode root) {
        BSTPair result = isBST(root);
        return result.isBST;
    }
    
    public BSTPair isBST(TreeNode node){
        
        if(node==null){
            BSTPair bpair = new BSTPair();
            bpair.min = Integer.MAX_VALUE + 1L;
            bpair.max = Integer.MIN_VALUE - 1L;
            bpair.isBST = true;
            return bpair;
        }
        
        
        BSTPair lpair = isBST(node.left);
        BSTPair rpair = isBST(node.right);
        
        BSTPair mypair = new BSTPair();
        mypair.min = Math.min(node.val, Math.min(lpair.min, rpair.min));
        mypair.max = Math.max(node.val, Math.max(lpair.max, rpair.max));
        
        if(lpair.isBST == true && rpair.isBST == true && lpair.max < node.val && node.val < rpair.min){
            mypair.isBST = true;
        }else{
            mypair.isBST = false;
        }
        
        return mypair;
    }
}
