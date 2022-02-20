// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: First node in inorder is the root. We make this the root node
// and then find this in the preorder. The left of this node gives us left subtree 
// and the right side the right subtree. We then recursively set the root.left
// by dividing our preorder until the left of found index and root.right from the 
// index towards the right.

// LC- 105. Construct Binary Tree from Preorder and Inorder Traversal

public class ConstructBSTFromPreAndInOrder {
  public class TreeNode {
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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
  }

  public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preStart]);

    // Searching for the index of root in inorder
    int inIndex = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        inIndex = i;
      }
    }

    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

    return root;
  }
}
