import java.util.*;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
    left = null;
    right = null;
  }
}

// utility function to insert node in the list
class PreONInorder {
  static TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
        inorder.length - 1, inMap);
    return root;
  }

  static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
      Map<Integer, Integer> inMap) {
    if (preStart > preEnd || inStart > inEnd)
      return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder,
        inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder,
        inRoot + 1, inEnd, inMap);

    return root;
  }

  public static void main(String args[]) {

    int preorder[] = { 3, 9, 20, 15, 7 };
    int inorder[] = { 9, 3, 15, 20, 7 };
    TreeNode root = buildTree(preorder, inorder);
  }

}