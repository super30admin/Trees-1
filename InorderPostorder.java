// Time Complexity : O(n) 
// Space Complexity : O(n) n = no of nodes in BST
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//1. Inorder Traversal is LEFT, ROOT, RIGHT and preorder traversal is ROOT, LEFT, RIGHT
//2. When preorder traversal is given we have the root node of the tree at the first index.
//3. By keeping track of index we can traverse the inorder and preorder array and build a BST.
import java.util.*;

public class InorderPostorder {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0)
      return null;
    int index = 0;
    TreeNode root = new TreeNode(preorder[0]);

    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == root.val) {
        index = i;
        break;
      }
    }
    int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
    int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);

    int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
    int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

    root.left = buildTree(preLeft, inLeft);
    root.right = buildTree(preRight, inRight);

    return root;

  }

  void printInorder(TreeNode node) {
    if (node == null)
      return;
    printInorder(node.left);
    System.out.print(node.val + " ");
    printInorder(node.right);
  }

  public static void main(String[] args) {

    InorderPostorder Tree = new InorderPostorder();
    int[] preorder = { 10, 4, 8, 7, 9, 3, 1, 18 };
    int[] inorder = { 8, 4, 7, 10, 3, 9, 1, 18 };
    TreeNode Binary_tree = Tree.buildTree(preorder, inorder);
    System.out.println("The Inorder Tree Traversal is");
    Tree.printInorder(Binary_tree);

  }

}
