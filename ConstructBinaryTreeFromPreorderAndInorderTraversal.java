// Time Complexity : O(n) Each node is visited once
// Space Complexity : O(n) HashMap stores all n nodes from inorder. Recursion stack can go up to O(n) in skewed tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// In preorder: root -> left -> right
// In inorder: left -> root -> right
// Preorder gives us the order of root nodes, and inorder helps in identifying the boundary of left and right subtrees.
// We use a HashMap to store the index of each node in the inorder array for O(1) access.
// A global index is used to track the root nodes in the preorder array as we build the tree recursively.
// For each node from preorder, we:
// 1. Create the node using preorder[idx].
// 2. Look up its index in inorder to split into left and right subtrees.
// 3. Recursively build left and right children using updated start/end ranges of the inorder array.
// This process continues until the entire tree is constructed.

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
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;
        //Mppulate the map with Node -> inorder Index
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,preorder.length-1);
    }

    private TreeNode helper(int[] preorder,int start,int end){
        //BC: If start crosses end return null(leaf node)
        if(start > end) return null;

        //Get the root value
        int rootVal = preorder[idx];
        idx++;

        //Get index
        int rootIdx = map.get(rootVal);

        //Create the root
        TreeNode root = new TreeNode(rootVal);

        //Left baby
        root.left = helper(preorder, start, rootIdx-1);

        //Right baby
        root.right = helper(preorder, rootIdx+1, end);

        return root;

    }
}