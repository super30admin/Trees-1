// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 



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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // brute force Solution
        // The TC is O(n^2) which is inefficient since we are doing copy of range which is 
        // O(n) TC times the recurrsion stack O(n), space will be O(n) as well

        // Null base condition
        if (preorder.length==0) return null;

        //get the root from preorder since it follows the root-->left-->right property
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // get the root from the inorder - this can be further optimized by using hashmap
        // since searching will be reduced to O(1) - more optimized

        int idx = -1;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal){
                idx = i;
                break;
            }
        }

        // lets start constructing the list of subtrees
        int [] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int [] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int [] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

        // assign left sub trees
        root.left = buildTree(preLeft,inLeft);
        // assign right sub trees
        root.right = buildTree(preRight,inRight);

        return  root;
    }
}