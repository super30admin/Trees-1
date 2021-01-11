// Time Complexity : The time complexity is O(n) where n is the number of nodes in the tree.
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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

        return getTree(preorder,inorder,0,0,inorder.length-1);

    }

    public TreeNode getTree(int[] preorder, int[] inorder,int preStart,int inStart,int inEnd){

        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }

        // In preorder, the first number would be the current root
        int num = preorder[preStart];
        int index = 0;

        // search for root in inorder
        for(int i=0;i<inorder.length;i++){

            if(inorder[i] == num){
                index = i;
                break;
            }

        }

        TreeNode root = new TreeNode(num);

        // The left child of the root is array from inStart to index
        root.left = getTree(preorder,inorder,preStart+1,inStart,index-1);

        // The right child of the root is array from index to inEnd
        root.right = getTree(preorder,inorder,preStart+1+index-inStart,index+1,inEnd);

        return root;
    }
}