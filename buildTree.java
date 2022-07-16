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
    HashMap<Integer,Integer> map;
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        map = new HashMap<>();
        
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }
        
        //int index = map.get(preorder[0]);
        
        return helper(preorder,inorder,0,len-1);

             
    }
    private TreeNode helper(int[] preorder, int[] inorder,int s,int e){
        
        //base
        if(s>e) return null;
        //logic
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        
        int rootIn = map.get(rootVal);
        
        root.left = helper(preorder,inorder,s,rootIn-1);
        root.right = helper(preorder,inorder,rootIn+1,e);
        
        return root;
                
    }
}