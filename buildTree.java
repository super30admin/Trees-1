/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map= new HashMap();
    int p =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder==null || preorder.length==0)
            return null;
        else{
            for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
            }
            return buildTree(preorder,inorder,0, preorder.length-1);
        }
        
    }
    
    public TreeNode buildTree(int[]pre,int[]in,int start,int end){
        if(start>end) return null;
        else{
            TreeNode root = new TreeNode(pre[p++]);
            int sub = map.get(root.val);
            root.left = buildTree(pre,in,start,sub-1);
            root.right = buildTree(pre,in,sub+1,end);
            return root;
        }
    }
}
