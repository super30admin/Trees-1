// Time Complexity : Need help
// Space Complexity :O(n) - using extra space "Hashmap"
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 
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
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return buildBinaryTree(preorder, inorder, 0, inorder.length, 0);
    }
    
    public TreeNode buildBinaryTree(int[] preorder,int[] inorder, int start, int end, int root){
        if(start >= end){
            return null;
        }        
        int index = map.get(preorder[root]);
        System.out.println(start + " " + end + " " + index + " " + root);
        TreeNode ans = new TreeNode(preorder[root]);
        ans.left = buildBinaryTree(preorder, inorder, start, index, root + 1);
        ans.right = buildBinaryTree(preorder, inorder, index + 1, end, root + index - start + 1);
        return ans;
    }
}