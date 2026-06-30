import java.util.HashMap;

import javax.swing.tree.TreeNode;
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
    /*
        TC - O(n)
        SC - O(n)
        Solution- In preorder traversal, the first element is always the root of the current subtree. We are using
        a HashMap stores the index of each value in the inorder array, allowing us to quickly find the root's position.
        Starting with the first element in the preorder array, we create the root node and move to the next element 
         using the global index idx. Using the root's position in the inorder array, we split the tree into the left subtree 
         (elements before the root in inorder), and the right subtree (elements after the root in inorder).
    */
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.idx = 0;
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int rootVal = preorder[idx];
        this.idx++;
        int rootIdx = map.get(rootVal);
        
        TreeNode node = new TreeNode(rootVal);
        node.left = helper(preorder, start, rootIdx - 1);
        node.right = helper(preorder, rootIdx + 1, end);

        return node;
    }
}