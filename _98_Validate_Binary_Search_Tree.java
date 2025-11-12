/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//So we can use the inorder property of BST i.e inorder traversal of BST is always sorted, so we store the inorder traversal of BST and check if it is sorted or not

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Rather than using the inorder property of BST, we can use an pointer and store the prev value,use global prev value(as it won't change when function call ends) traverse the tree in inorder and while going to left check if prev is less than root or not, if not return false, else update prev with root and move right.

/**** Method 3 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Rather than using the global previous variable, we can use a min and max, we initiate min and max with LONG.MIN_VALUE and LONG.MAX_VALUE, and check we node value lies in between min and max if not return false else continue left recursive call but max will be replaced by node value as left should not be greater than node or root, and do the same with right but replacing min with node value.

import java.util.ArrayList;
import java.util.List;

public class _98_Validate_Binary_Search_Tree {

  /**** Method 1 ****/
  public boolean isValidBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    helper(root, list);

    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) <= list.get(i - 1)) {
        return false;
      }
    }

    return true;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    helper(root.left, list);
    list.add(root.val);
    helper(root.right, list);
  }

  /**** Method 2 ****/

  TreeNode prev;

  public boolean isValidBST1(TreeNode root) {
    return helper(root);
  }

  private boolean helper(TreeNode root) {
    if (root == null) return true;

    if (!helper(root.left)) return false;

    if (prev != null && prev.val >= root.val) {
      return false;
    }

    prev = root;
    return helper(root.right);
  }

  /**** Method 3 ****/

  public boolean isValidBST2(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValid(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return (
      isValid(node.left, min, node.val) && isValid(node.right, node.val, max)
    );
  }
}
