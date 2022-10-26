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
//SC: O(n)

// Approach: In pre-order you will encounter root first take that element and find the index in the in-order traversal now you can safely assume that the elements which are left in the in-order traversal will be left side of your root and elements in the right will be towards right side of your root in the tree.
class Solution {

  public int preIndex;
  int[] preorder;
  int[] inorder;
  HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preIndex = 0;
    this.preorder = preorder;
    this.inorder = inorder;
    for(int i=0; i<inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return solve(preorder, 0, inorder.length-1);
  }

  private TreeNode solve(int[] preorder, int start, int end) {


    // base case:
    if(start > end)
      return null;



    // recursion:
    TreeNode node = new TreeNode(preorder[preIndex]);
    int idx = map.get(preorder[preIndex]);
    preIndex++;
    node.left = solve(preorder, start, idx-1);
    node.right = solve(preorder, idx+1, end);

    return node;
  }





}