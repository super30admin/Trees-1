//Time - O(n)
//Space -  O(n)
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
    HashMap<Integer,Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(0,preorder,inorder,0,inorder.length);
    }

    public TreeNode helper(int idx, int[] preorder, int[] inorder, int si, int ei){
        if(idx>= preorder.length || si>=ei){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        int rootidx = hm.get(root.val);
        root.left = helper(idx+1,preorder,inorder,si, rootidx );
        root.right = helper(idx+(rootidx-si+1), preorder,inorder, rootidx+1, ei);
        return root;
    }
}
