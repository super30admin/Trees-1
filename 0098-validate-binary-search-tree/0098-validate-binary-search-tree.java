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
    boolean flag; //Flag to track if the tree is a valid BST
    TreeNode prev; //Pointer to the previous node in inorder traversal

    public boolean isValidBST(TreeNode root) {
/*
Approach: 
A binary Search Tree must satisfy the property:
    For every node, all values in its left subtree are< node.val,
    and all values in the right subtree are> node.val.

In-order traversal of a BST gives values in strictly increasing order.

-We do an in-order traversal and keep track of the previouslty visited node ('prev')
    At each step, if current.val<= prev.val, it violates the BST rule.

-We use a flag to indicate if the tree is valid. If a violation is found,
we set flag = false and skip further unnecesary traversal.
*/
        this.flag = true; //Initialize flag as true
        helper(root); //Start inorder traversal
        return flag;//Final decision on BST validity
    }

    //Recursive helper function for inorder traversal
    private void helper(TreeNode root){
        //Base case: null node
        if(root == null) return;

        //If still valid, recurse into left subtree
        if (flag){
            helper(root.left);
        }

        //Check the current node against the previous node visited
        if(prev!=null && prev.val >= root.val){
            flag = false; //Invalide BST condition not strictly increasing
        }

        //Update the previous node pointer
        prev = root;

        //If still valid, recurse into right sub tree
        if(flag){
            helper(root.right);
        }
    
/*
Time Complexity:
O(n), where n is the number of nodes in the tree.
-Each node is visited exactly once in in-order traversal

Space Complexity:
O(h), where h is the height of the tree.
This is the recursion stack space. For a balances tree, h = logn., for a skewed tree, h =n

*/      












    }
}