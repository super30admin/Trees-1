// Time Complexity :O(N*N) , N recursive calls
// Space Complexity : O(N*N) , we are creating 4 new arrays for every call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/**
*This is not the optimized approach, we are creating four new arrays for each left and right inorder and
 * preorder arrays . We are searching for the root node in every call.
 * Optimized approach, we can store the root index in Hashmap , to reduce the search complexity for
 * seraching the root node.
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
class Problem2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null cases
        if(preorder.length == 0) return null;

        int rootVal = preorder[0];

        //adding root to the tree
        TreeNode root = new TreeNode(rootVal);

        //iterating over the inorder array to look for root index
        int idx = -1;

        for(int i=0; i<inorder.length; i++){

            if(inorder[i] == rootVal){

                idx = i;
                break;
            }
        }
        //making four arrays
        //idx is the root index from preorder

        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx); //idx will not be included
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

        //building the ree
        root.left = buildTree(preLeft , inLeft);
        root.right= buildTree(preRight, inRight);


        return root;
    }
}