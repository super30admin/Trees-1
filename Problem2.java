// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We keep a pointer on preorder array to determine the root
We create a hash map for inorder tree for quick search of node and its index
We recurse left first (because preorder is root-left-right), then build the right subtree.
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
    int idx = 0; //pointer on preorder
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Hash map to store indorder index
        this.map = new HashMap<>();
        for(int i=0; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        //base
        if (start > end) return null;
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        //get the root index
        int rootIdx = map.get(rootVal);
        //recursive call for left subtree
        root.left = helper(preorder, start, rootIdx-1);
        //recursive call for right subtree
        root.right = helper(preorder, rootIdx+1, end);

        return root;


    }
}
