
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
class ValidBSTUsingRange {

    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag=true;

        //having max and min in local scope
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max)
    {
        //base case
        if(root == null) return;

        //logic {preorder}

        //Failure or breach check
        if(min != null && root.val <= min) { //equal sign because we cant have same values in nodes
            flag = false;
        }

        if(max != null && root.val >= max) {
            flag = false;
        }

        //traversals
        if(flag)
            helper(root.left, min, root.val); //left traversal

        if(flag)
            helper(root.right, root.val, max); //right traversal
    }
}

/*
        //logic {inorder}

        //traversals
        helper(root.left, min, root.val); //left traversal

                //Failure or breach check
                if(min != null && root.val <= min) { //equal sign because we cant have same values in nodes
                    flag = false;
                }

                if(max != null && root.val >= max) {
                    flag = false;
                }

        helper(root.right, root.val, max); //right traversal

        ============================================================================================================
        //logic {postorder}

        //traversals
        helper(root.left, min, root.val); //left traversal

        helper(root.right, root.val, max); //right traversal

                //Failure or breach check
                if(min != null && root.val <= min) { //equal sign because we cant have same values in nodes
                    flag = false;
                }

                if(max != null && root.val >= max) {
                    flag = false;
                }
 */