//Time Complexity: O(n)
//Space Complexity: O(h)
//Create an inorder method to check if each root is valid.
//Using recursion to traverse through each side of the tree.

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
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }

    //Helper method to check nodes in order
    public void inorder(TreeNode root){
        //base
        if(root==null) return;

        if(!flag) return;

        //left
        inorder(root.left);
        System.out.print("up");
        System.out.print(root.val);

        if(prev!= null && prev.val >= root.val){
            //breach!
            flag = false;
            return;
        }
        prev = root;

        //right
        if(flag){
            inorder(root.right);
            System.out.print("down");
            System.out.print(root.val);
        }
    }
}