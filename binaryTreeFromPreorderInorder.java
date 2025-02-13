// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, the values of inorder are kept in hashmap for lookup when needed. Helper function is used for recursive functions with preorder, map,
 * start index and end index in which the value lie. For left tree, the start index is the start of parent index and the end is the root index-1.
 * For right tree, the start is the root index + 1 and end is end of the parent root. Finally root is returned.
 */

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

    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, map, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end){
        //base
        if(start>end) return null;

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;

        int rootIdx = map.get(root.val);

        root.left = helper(preorder, map, start, rootIdx-1);
        root.right = helper(preorder, map, 1+rootIdx, end);

        return root;
    }
}