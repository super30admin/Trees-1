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
//sc- o(h)
//o(n)
///ip- [100,40,120,20,60,110,140,10,30,50,70,null,115,135,160]
class Solution {
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return true;
        
    }
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        //stack.pop()=root;
        System.out.print("up");
        System.out.println(root.val);
        
        inorder(root.right);
        //stack.pop()=root;
        System.out.print("down");
        System.out.println(root.val);
    }
}