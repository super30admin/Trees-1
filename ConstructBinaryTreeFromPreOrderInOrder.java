//Time Complexity: O(n)
//Space Complexity: O(n)


/**
 * Constructs a binary tree from preorder and inorder traversal arrays.
 * Uses recursion with a HashMap to track inorder indices for efficient lookup.
 * Maintains a global index to traverse the preorder array sequentially.
 */

import java.util.*;

public class ConstructBinaryTreeFromPreOrderInOrder {

 // Definition for a binary tree node.
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
 
    int index;
    Map<Integer, Integer> hmap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0)
            return null;
        this.index = 0;
        this.hmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return helper(preorder, hmap, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, Map<Integer, Integer> hmap, int start, int end) {

        if (start > end)
            return null;
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = hmap.get(rootVal);

        root.left = helper(preorder, hmap, start, rootIndex - 1);
        root.right = helper(preorder, hmap, rootIndex + 1, end);

        return root;

    }
}
    

