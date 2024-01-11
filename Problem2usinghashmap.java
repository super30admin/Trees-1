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
 //TC: O(n)
 //
 //SC = O(n)
 class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end) return null;
        //where is root 
        int rootVal = preorder[index];
        index++;
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start,rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);
        return root;
    }
}