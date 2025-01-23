
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

  int index;
  Map<Integer, Integer> map;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder.length == 0) {
      return null;
    }
    map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return createTree(preorder, 0, preorder.length - 1);
  }

  private TreeNode createTree(int[] preorder, int start, int end) {
    if (start > end) {
      return null;
    }
    int rootValue = preorder[index];
    index++;
    TreeNode root = new TreeNode(rootValue);
    int rootIndex = map.get(rootValue);
    root.left = createTree(preorder, start, rootIndex - 1);
    root.right = createTree(preorder, rootIndex + 1, end);
    return root;
  }

  class TreeNode {
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
}
