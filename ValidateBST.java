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
 /**
 This Java solution validates a binary tree as a binary search tree (BST) using an inorder traversal. 
 It maintains a boolean flag to track violations of the BST property, updating it during the traversal. 
 The final result is based on the flag, indicating whether the binary tree is a valid BST.
 Time Complexity: O(N) - where N is the number of nodes in the binary tree
 Space Complexity: O(H) - where H is the height of the binary tree. The space used by the recursive call stack is proportional to the height of the tree. In the worst case, the height is O(N), making the space complexity O(N).

 */
class Solution {
    TreeNode prev;
    boolean flag;
        
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        inorder(root);
        return flag;
        
        
    }
    private void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;

        }
        prev = root;
         inorder(root.right);

    }
}