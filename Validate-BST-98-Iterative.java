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

 // Iterative Approach
 // Time Complexity: O(n) where n is the number of elements in the in the tree
 // Space Complexity: O(1)
 // As we are doing inorder traversal which means the tree is going to be in ascending order always
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) // If tree is empty
        {
            return true;
        }
        Stack<TreeNode> s = new Stack<>(); // Creating new Stack which stores root
        TreeNode prev = null; // Counter to check current and prev value

        while(root!=null || !s.isEmpty()) 
        // Condition root is not null checks if tree is emoty or not
        // Consition stack is not empty ensures that while when a node with no right side comes in picture it deals with that condition
        {
           while(root!=null)
           {
               // push left nodes of the tree
               s.push(root);
               root=root.left;
           }
           // Once all left nodes are pushed and root is now null, take the top element of the stack and get the right child of that node.
           root = s.pop();
           // checking if the tree is following ascending order
           if(prev!=null && prev.val>=root.val)
           {
               return false;
           }
           // storing current value to prev for further comparison
            prev = root;
           System.out.println(root.val);
           // right side of node
           root = root.right;

        }
        return true;
    }
}
