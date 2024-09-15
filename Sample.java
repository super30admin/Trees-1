// Problem1 - Validate Binary Search Tree
// Time Complexity - O(n) where n = number of nodes
// Space Complexity - O(n)

// Algorithm
// 1 - perform inorder traversal
// 2 - if prev greater than curr, return false
// 3 - else change prev to current root
// 4 - root to root's right
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
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
        return true;
    }

    // 1
    Stack<TreeNode> stack = new Stack<>();
    TreeNode prev = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.pop();
      // 2
      if (prev != null && prev.val >= root.val) {
        return false;
      }
      // 3
      prev = root;
      // 4
      root = root.right;
    }

    return true;
  }
}

// Problem2 - Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity - O(n) where n = number of nodes
// Space Complexity - O(n)

// Algorithm
// 1 - identify root
// 2 - get the index of root from inorder
// 3 - get 4 subarrays
// 4 - recursion over left
// 5 - recursion over right
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
    if (preorder.length == 0 || inorder.length == 0) {
      return null;
    }
    // 1
    TreeNode root = new TreeNode(preorder[0]);
    // 2
    int index = -1;
    for (int i=0; i<inorder.length; i++) {
        if (inorder[i] == root.val) {
          index = i;
        }
    }
    // 3
    int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
    int[] inLeft = Arrays.copyOfRange(inorder, 0, index);

    int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
    int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
    // 4
    root.left = buildTree(preLeft, inLeft);
    // 5
    root.right = buildTree(preRight, inRight);

    return root;
  }
}
