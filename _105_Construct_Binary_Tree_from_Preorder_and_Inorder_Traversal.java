/**** Method 1 ****/
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

//Successfully submitted in LeetCode

//The root is always the first element in preorder, so we find the it's index in inorder, so that we can partition array into left and right as all the elements present before the root in inorder are left and after are right, so we build a treenode with root and then assign node.left with both left parts of arrays and node.right with right arrays.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Rather than slicing the array, we can use indexs and a map with values and index of inorder array to reduce lookup time.

import java.util.Arrays;
import java.util.HashMap;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder.length == 0) {
      return null;
    }

    int val = preorder[0];

    TreeNode root = new TreeNode(val);
    int idx = 0;

    for (int i = 0; i < inorder.length; i++) {
      if (val == inorder[i]) {
        idx = i;
        break;
      }
    }

    int preorderLeft[] = Arrays.copyOfRange(preorder, 1, idx + 1);
    int preorderRight[] = Arrays.copyOfRange(
      preorder,
      idx + 1,
      preorder.length
    );
    int inorderLeft[] = Arrays.copyOfRange(inorder, 0, idx);
    int inorderRight[] = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

    root.left = buildTree(preorderLeft, inorderLeft);
    root.right = buildTree(preorderRight, inorderRight);

    return root;
  }

  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder.length == 0) {
      return null;
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(
      preorder,
      0,
      preorder.length - 1,
      inorder,
      0,
      inorder.length - 1,
      map
    );
  }

  private TreeNode helper(
    int[] preorder,
    int preStart,
    int preEnd,
    int[] inorder,
    int inStart,
    int inEnd,
    HashMap<Integer, Integer> map
  ) {
    if (preStart > preEnd || inStart > inEnd) return null;

    int val = preorder[preStart];

    TreeNode root = new TreeNode(val);
    int idx = map.get(val);
    int leftSize = idx - inStart;

    root.left = helper(
      preorder,
      preStart + 1,
      preStart + leftSize,
      inorder,
      inStart,
      idx - 1,
      map
    );
    root.right = helper(
      preorder,
      preStart + leftSize + 1,
      preEnd,
      inorder,
      idx + 1,
      inEnd,
      map
    );

    return root;
  }
}
