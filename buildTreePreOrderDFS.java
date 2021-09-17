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
// Time Complexity: Putting in map n and recursing through values n => O(n)
// Space Complexity: additional datastructure used (map) of size O(n)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach:
// Idea here is to put all elements of inorder as key and index as value in a map.
// first element of preorder can be root only. Finding its index and recursing using 2 pointers on left and right side of that index gives us left subtree and right subtree of that index
class Solution {
    int idx;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0) return null;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder, int start, int end) {
        // base
        if(start>end) return null;
        // logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rIdx = map.get(rootVal);
        idx++;
        
        root.left = helper(preorder, start, rIdx-1);
        root.right = helper(preorder, rIdx+1, end);
        return root;
    }
}