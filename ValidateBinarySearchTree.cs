//Time Complexity: O(n) 
//Space Complexity: o(h) -> log(n) because balanced binary tree; h is height of tree

//complete/perfect/balanced

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    TreeNode prev;
    bool flag;
    public bool IsValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        //Console.WriteLine(list);
        return flag;
    }

    public void helper(TreeNode root){
        //base code
        if(root == null) return;

        helper(root.left);
        Console.WriteLine(root.val);
        if(prev!=null && prev.val >= root.val){
            flag = false;
        }

        prev = root;

        helper(root.right);
    }

}