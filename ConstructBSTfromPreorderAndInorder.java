// TC: O(n)
// Each node is created once, and hashmap lookup for root index is O(1).
// SC: O(n)
// HashMap storage (O(n)) + recursive call stack (O(n) in worst case of skewed tree)

// Approach:
// 1. We keep pointer or index into the preorder array. That tells us what the current root node should be.
// The very first element in preorder is always the root

// 2. We then look at the inorder array to figure out where the root sits. Everything to left of root in inorder belongs 
//  to left subtree and everything to right belongs to right subtree

// 3. We use recursion to build the tree
// First we build the left subtree from the left portion of inorder 
// then we build the right subtree from right portion of inorder
// Each time we move forward in preorder to pick the root

// 4. To avoid searching linearly in inorder, we store indices of inorder values in hashmap.
// That way we can directly jump to root's position in constant time

import java.util.HashMap;

public class ConstructBSTfromPreorderAndInorder {
  static int idx = 0;

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    idx = 0;
    return helper(preorder, map, 0, inorder.length - 1);
  }

  private static TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
    // base
    if (start > end)
      return null;

    // logic
    int rootVal = preorder[idx];
    idx++;
    TreeNode root = new TreeNode(rootVal);
    int rootIdx = map.get(rootVal);

    root.left = helper(preorder, map, start, rootIdx - 1);
    root.right = helper(preorder, map, rootIdx + 1, end);

    return root;
  }

  private static void printInorder(TreeNode root) {
    if (root == null)
      return;
    printInorder(root.left);
    System.out.print(root.val + " ");
    printInorder(root.right);
  }

  public static void main(String[] args) {
    int[] preorder = { 3, 9, 20, 15, 7 };
    int[] inorder = { 9, 3, 15, 20, 7 };

    TreeNode root = buildTree(preorder, inorder);

    // Verify with inorder traversal
    printInorder(root);
  }
}
