// TC - O(n)
// SC - O(n)

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
       return helper(preorder,inorder,0,inorder.length-1,map);
    }

    
    public TreeNode helper(int[] preorder, int[] inorder,int start,
                          int end, HashMap<Integer,Integer> map){
        
        if(start>end ) return null;
        
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        idx++;
        root.left = helper(preorder,inorder,start,rootIdx-1,map);
        root.right = helper(preorder,inorder,rootIdx+1,end,map);
        
        return root;
}
}