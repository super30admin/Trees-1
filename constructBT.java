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
    HashMap<Integer,Integer>map;
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map= new HashMap<>();
        preIndex=0;
        
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return ArrTree(preorder, 0, preorder.length-1);
    }
    
    private TreeNode ArrTree(int[] preorder,int left, int right){
        //base
        if(left>right) return null;
        
        int rootValue= preorder[preIndex++];
       TreeNode root = new TreeNode(rootValue);
        
        
        root.left= ArrTree(preorder,left,map.get(rootValue)-1);
        root.right= ArrTree(preorder,map.get(rootValue)+1,right);
        return root;
        
    }
}
