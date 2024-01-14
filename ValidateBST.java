import java.util.Stack;

/*** Using Prev Pointer Recursive*****/
// Time Complexity : O(n)n is the number of nodes in a tree
// Space Complexity : O(h)  h is height of the tree
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :

/*** Using Min & Max Recursive *****/
// Time Complexity : O(n) n is the number of nodes in a tree
// Space Complexity : O(h) h is height of the tree
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :

/*** Using Iterative *****/
// Time Complexity : O(n) n is the number of nodes in a tree
// Space Complexity : O(h)  h is height of the tree
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :
public class ValidateBST {

    boolean flag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        //iterative solution
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;

        }
        // this.flag = true;
        // helper(root);
        // helper(root,null,null);
        return true;

    }

    // Method 2. have a prev pointer
    /*
     * public void helper(TreeNode root)
     * {
     * //base
     * if(root == null)
     * return;
     * 
     * 
     * System.out.println(root.val);
     * 
     * helper(root.left);
     * if(prev!=null && prev.val >= root.val)
     * {
     * flag = false;
     * }
     * 
     * prev = root;
     * 
     * 
     * 
     * helper(root.right);
     * }
     */

    // Method 1. Min & Max
    public void helper(TreeNode root, Integer min, Integer max) {
        // base
        if (root == null)
            return;

        if (max != null && root.val >= max) {
            flag = false;
        }
        if (min != null && root.val <= min) {
            flag = false;
        }
        System.out.println(root.val);
        if (flag)
            helper(root.left, min, root.val);

        if (flag)
            helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Function call
        System.out.println(bst.isValidBST(root));
    }
}
