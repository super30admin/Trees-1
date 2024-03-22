import java.util.HashMap;
//tc  = o(n) visit all nodes once
//sc = o(n) recursive stack and hashmap
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
    int idx = 0;
    private TreeNode helper(int[] preorder,HashMap<Integer,Integer> map,int start,int end){
        if(start > end)return null;
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,map,start,rootIdx-1);
        root.right = helper(preorder,map,rootIdx+1,end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,map,0,inorder.length-1);
       
    }
}