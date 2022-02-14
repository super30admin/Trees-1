import javax.swing.tree.TreeNode;
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NP
public class ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//INORDER
    TreeNode prev;
        boolean flag;
        public boolean isValidBST(TreeNode root) {
            if(root.left == null && root.right==null) return true;
            flag = true;
            isValidNode(root);
            return flag;
        }
        private void isValidNode(TreeNode root)
        {
            //base
            if(root == null) return;
            //logic
            isValidNode(root.left);
            // System.out.println(root.val +" up ");
            if(prev!=null)
                System.out.println(root.val +" prev " + prev.val);
            if(prev!=null && prev.val >= root.val) {
                flag = false;
                return;
            }
            prev = root;
            isValidNode(root.right);
        }


    //////////////////////////
// RANGE SOLUTION
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

            return helper(root, null, null);
        }
        private boolean helper(TreeNode root, Integer min, Integer max) {
            //base
            if(root == null) return true;
            if((min!= null && root.val<=min) || (max!=null && root.val>=max)) return false;

            //logic
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
    }
}
