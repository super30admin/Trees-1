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
class problem-2 {
    int sum = 0;    //global variable that we calculate in function dfs and return in below func.
    public int sumNumbers(TreeNode root) {
        dfs(root , 0);
        return sum;
    }

    private void dfs(TreeNode root, int CurrSum){
        if(root == null){   //base case
            return;
        }

        dfs(root.left, CurrSum * 10 + root.val);

        if(root.left == null && root.right == null){
            sum = sum + CurrSum * 10 + root.val;
            return;
        }

        dfs(root.right, CurrSum * 10 + root.val);

    }
}