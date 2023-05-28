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

//tc=O(n)
//sc=O(n)
 class Solution {
    HashMap<Integer, Integer> m;
    int index; // initially 0, always tracks root node of subtrees

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 ||
        inorder == null || inorder.length == 0) {
            return null;
        }

        // create a HashMap to optimize lookup of root node in inorder traversal array
        m = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            m.put(inorder[i], i);
        }

        // then use preorder to construct tree by keeping
        // pointers for start and end of each subtree.
        // initially the subtree is the entire tree, so start and end
        // are 0 and len-1
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);

        // fetch from inorder array so that left and right subtrees can
        // be created from a split inorder array
        int rootIndex = m.get(rootVal); 

        root.left = helper(preorder, start, rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);

        return root;
    }
}