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

//TC: O(n)
//Sc: O(n)

// Approach: In in-order traversal the elements will be sorted. so for a valid BST try to check if your current element is greater than prev element (sorted property holds). Then it is a valid BST.


class Solution {

  private long prev;
  public boolean isValidBST(TreeNode root) {
    prev = Long.MIN_VALUE;
    return solve(root);
  }

    /*
    Recursive in-order method.
    private boolean solve(TreeNode root) {

        if(root == null)
            return true;



        boolean left = solve(root.left);
        if(!left) {
            return false;
        }
        if(root.val <= prev) {
            return false;
        }
        prev = root.val;
        boolean right = solve(root.right);


        return right;


    }*/

  // Iterative in-order method.
  private boolean solve(TreeNode root) {

    Stack<TreeNode> st = new Stack<>();

    while(root!=null) {
      st.push(root);
      root = root.left;
    }

    while(!st.isEmpty()) {
      if(st.peek().val <= prev) {
        return false;
      }
      root = st.pop();
      prev = root.val;
      if(root != null)
        root = root.right;
      while(root!=null) {
        st.push(root);
        root=root.left;
      }
    }

    return true;

  }

}