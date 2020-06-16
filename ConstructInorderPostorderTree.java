//Time complexity: O(N) where N is length of inorder and preorder
//Space complexity: O(N) auxilliary space for hashmap and O(H) stack space where H is height of the tree
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
    HashMap<Integer, Integer> result;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        result = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            result.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start > end) return null;
        
        //logic
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int inorderIdx = result.get(root.val);
        root.left = helper(preorder, inorder, start, inorderIdx-1);
        root.right = helper(preorder, inorder, inorderIdx+1, end);
        
        return root;
    } 
}