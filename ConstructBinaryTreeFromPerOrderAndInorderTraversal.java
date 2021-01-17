import javax.swing.tree.TreeNode;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Getting started and trying to undertsand how to construct the tree

// Your code here along with comments explaining your approach
public class ConstructBinaryTreeFromPerOrderAndInorderTraversal {

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
           return helper(0, 0, inorder.length-1, preorder, inorder);
        }

        public TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder){
            if(preStart > preOrder.length-1 || inStart > inEnd) return null;

            //set root node
            TreeNode root = new TreeNode(preOrder[preStart]);

            //set left and right nodes
            int inindex=0;

            for (int i = inStart; i <= inEnd ; i++) {
                if(root.val == inOrder[i]){
                    inindex = i;
                }
            }

            root.left = helper(preStart + 1, inStart, inindex -1, preOrder, inOrder);
            root.right = helper(preStart + inindex - inStart + 1, inindex + 1, inEnd, preOrder, inOrder);

            return root;
        }
    }


}
