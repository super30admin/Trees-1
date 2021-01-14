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
    private HashMap <Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] pre, int[] in) {
            for(int i=0;i<in.length;i++){
                map.put(in[i],i);
            }
        return buildT(0,0,in.length-1,pre,in);
    }
    private TreeNode buildT(int preOrderIndex,int inOrderIndex,int end,int[] pre,
                          int[] in){
        if(preOrderIndex>pre.length-1 || inOrderIndex>end) return null;
        
        TreeNode root = new TreeNode(pre[preOrderIndex]);
        
        root.left = buildT(preOrderIndex+1,inOrderIndex
                           ,map.get(pre[preOrderIndex])-1,pre,in);
        root.right = buildT(preOrderIndex
                            + map.get(pre[preOrderIndex])-inOrderIndex+1
                            ,map.get(pre[preOrderIndex])+1,end,pre,in);
        
        return root;
    }
}


