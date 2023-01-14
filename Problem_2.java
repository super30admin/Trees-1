// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// Store the Inorder tree value(key) and index(value) in a Map, so that while searching for root & root index -1, will get in O(1) time.
// Search the root value in Preorder traversal & increase the index after every call.
// Then search the root value in Map to know the root's index. After getting that we will find the desired array for that particular call and about the start index for right call(which is root index -1) & end index for left call(which is root index -1).


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
    int idx = 0; //index on preorder Arrays

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }


    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        //base
        if(start > end)
            return null;

        //logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal); //root index in inorder Arrays
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }
}