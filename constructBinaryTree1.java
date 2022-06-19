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
    //Time complexity: O(n)
    //Space complexity: O(n)
    Map<Integer,Integer> hm;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        hm=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder,int s,int e){
        if(s>e)
            return null;
        int rootVal=preorder[idx];
        TreeNode root=new TreeNode(rootVal);
        idx++;
        int rootIdx=hm.get(root.val);
        root.left=helper(preorder,s,rootIdx-1);
        root.right=helper(preorder,rootIdx+1,e);
        return root;
    }
}