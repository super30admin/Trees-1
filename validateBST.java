//Time Complexity: O(n) since we touch every node
//Space Complexity: O(h) due to recursion

//Concept:
/* For BST, we know that the left subtree always less than the root and right subtree is always
greater than the root. This should be true for all the subtrees.
In BT, we can have upto 2 children for each node. In BST, there should not
be any duplicate nodes. 
*/

//Code
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null,null);
    }
    
    private boolean validate(TreeNode node, Integer low, Integer high){
        //check node
        if(node == null)
            return true;
        
        //check node value
        if((low != null && node.val <= low) || (high!=null && node.val >= high)){
            return false;
        }
        
        //Check Left subtree and Right subtree
        return validate(node.left, low, node.val) && validate(node.right, node.val ,high);
            
    }
}