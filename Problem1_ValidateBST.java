/********** Time Complexity: O(n) **********/
/********** Space Complexity: O(n) **********/
//using stack memory

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean isValidBST(TreeNode root) {
     
    //considering stack for dfs processing
    Stack<TreeNode> st = new Stack();
    //initializing with max value to inorder
    double inorder = - Double.MAX_VALUE;

    //while stack is not mepty and has an element
    while (!st.isEmpty() || root != null) {
      while (root != null) {
        st.push(root);
        root = root.left;
      }
      root = st.pop();
      // If next element in inorder is smaller than the previous one
      if (root.val <= inorder) return false;
      inorder = root.val;
      root = root.right;
    }
    return true;
  }
}

/********************************************************************************* */

/********** Time Complexity: O(n) **********/
/********** Space Complexity: O(n) **********/
//using Recursion

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root,null, null);
    }
    
    public boolean isValidBSTRecursive(TreeNode root, Integer min, Integer max){
        if(root==null) return true;
        if((min!=null && root.val<=min) || (max!=null && root.val>=max)){
            return false;
        }
        return(isValidBSTRecursive(root.left,min, root.val) &&
              isValidBSTRecursive(root.right,root.val, max));
    }
}