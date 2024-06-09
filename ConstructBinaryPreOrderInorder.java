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
 //Time Complexity - O(n)
 //Space - O(n)
 class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx = 0;
        return recurse(preorder,0,inorder.length-1);    
         
    }
    private TreeNode recurse(int[] preorder, int start,int end){
        //Base case
        if(start > end){
            return null;

        }
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = recurse(preorder,start,rootIndex - 1);
        root.right = recurse(preorder,rootIndex + 1, end);
        return root;
    }
}
