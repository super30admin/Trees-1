// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// use preorder for tree root, and make hash map of inorder to find left and right tree.
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
    int [] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        pre = preorder.clone();
        idx = 0;
        
        for(int i =0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recurse(0, inorder.length-1);
    }
    private TreeNode recurse(int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = pre[idx];
        idx++;

        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = recurse(start, rootIdx-1);
        root.right = recurse(rootIdx+1, end);

        return root;
    }
}