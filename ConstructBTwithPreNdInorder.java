// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//We identify first element of preorder as root and increment through rest of the elements.
//we create hashmap for inorder and search the root with o(1)
//We use two pointers. We determine index of the root and set start and end pointers using index value
//If we start and end pointer is overlapping we create/return null node.


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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end){
            return null;
        }
        //logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        //left
        root.left = helper(preorder, start, rootIdx-1);
        //right
        root. right = helper(preorder, rootIdx+1, end);
        return root;
    }
}