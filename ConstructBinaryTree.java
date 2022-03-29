/**
 * Time complexity O(n)
 * space complexity O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, preorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend) {
            return null;
        }
        int rootVal = preorder[prestart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexMap.get(rootVal);
        int leftTreeSize = rootIndex - instart;
        int rightTreeSize = inend - rootIndex;
        
        root.left = buildTree(preorder, prestart+1, prestart+leftTreeSize, inorder, instart, rootIndex-1);
        root.right = buildTree(preorder, prestart+leftTreeSize+1, preend, inorder, rootIndex+1, inend);
        return root;
        
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}