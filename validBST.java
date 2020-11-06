//Attempted with reccursive method
//Time complexity O(n)
//Space complexity O(n)
/**
 * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 */
class Solution {
    //helper function that checks the condition for BST for any node
    public boolean BSThelper(TreeNode node, Integer lower, Integer upper)
    {
        //If null then return true as it is then a BST
        if(node == null) return true;
        //store the value of node at val
        int val = node.val;
        //check if the left of node is greater than the node then it is not a BST
        if(lower!=null && val <= lower) return false;
        //check if the right of node is smaller than the node then it is not a BST
        if(upper!=null && val >= upper) return false;
        
        //check the same conditions for the left and right of the children nodes 
        //If false return false as not a BST
        if(!BSThelper(node.right, val, upper)) return false;
        if(!BSThelper(node.left, lower, val)) return false;
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        //helper function that checks the condition for BST for root node
        return BSThelper(root, null, null);
    }
}