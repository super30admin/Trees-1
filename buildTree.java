// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;	// Base Case
        
        Stack<TreeNode> s = new Stack<>();		// using stack to retrieve the data for BST
        
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;					// since we know that the first element in preorder is always the root element, initialize the root and iterate through 1
        
		/* preorder = [3,9,20,15,7]			inorder = [9,3,15,20,7]
		
		preorder[0] = root
		find where the root is in the inorder, left of the value belongs to left subtree and right of the value belongs to right subtree
		
		1st iteration  				
		root - 3
		Left subtree - 9
		right subtree - 15,20,7		now we find the root in this array using preorder, and determine left and right subtree.
		*/
		
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                s.push(cur);
                cur = cur.left;
            } else {
                j++;
                while (!s.empty() && s.peek().val == inorder[j]) {
                    cur = s.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
}