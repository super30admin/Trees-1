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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true; //Set flag as true
        TreeNode[] prev = new TreeNode[1]; //Size of prev as a node is 1
        helper(root, prev);
        return flag;
    }

    private void helper(TreeNode root, TreeNode[] prev){ //with an array, we're not actually passing the entire array, but just a reference to it. So, when we pass an array to a method and modify its content inside the method, those modifications are reflected outside the method as well. But if we pass prev as an integer, we're essentially passing a copy of its value to the helper method. Any changes made to the integer inside the helper method will not affect the original integer outside the method. Which is why pass prev as an array in this case.
        //base
        if(root == null || !flag) return;

        if(prev[0] != null && prev[0].val >= root.val){
            flag = false; //If prev is greater than root then the flag is set to false
        }

        //logic
        helper(root.left, prev);
        System.out.println(prev[0]);
        prev[0] = root;


        if(flag)
            helper(root.right, prev);
    }
}