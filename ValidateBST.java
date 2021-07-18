import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBST {

    /*
    TC : O(N) where N is the number of nodes as we visit each node only once
    SC : O(N) for the recursive stack
    Leetcode : yes
    Problems? : No
     */

    /**
     * The approach here is simple : Any Node will be a BST if its left and right child are BST.
     * We maintain two pointers -low and high and use recursion to traverse the tree.
     * For the left child, we pass high == root.val and right child we pass low == root.val.
     * This way we can ensure that all valid checks are performed and
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {


        if (root == null)
            return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;

        return helper(root.left, low, root.val) && helper(root.right, root.val, high);

    }


    /*
    TC : O(logN)
    SC : O(logN)
     */

    /**
     * The appraoch used here is inorder traversal and a prev node is maintained.
     * For inorder traversal of a binary serach tree, we get nodes in ascending order. Whenever this property is violated, we know that its
     * not a valid BST.
     */
    public boolean result = true;
    public Integer prev;

    public boolean isValidBST_inorder_approach(TreeNode root) {
        prev = null;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.val <= prev) {
            result = false;
            return;
        }
        prev = root.val;
        inorder(root.right);
    }


     /*
    TC : O(logN)
    SC : O(logN)
     */

    /**
     * The same appraoch as above, just returned true/false instead of using a global variable
     */

    public Integer prev1;

    public boolean isValidBST_inorder_approach_two(TreeNode root) {
        prev1 = null;

        return inorder_boolean_return(root);
    }

    private boolean inorder_boolean_return(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inorder_boolean_return(root.left))
            return false;

        if (prev1 != null && root.val <= prev1) {
            return false;
        }
        prev1 = root.val;
        return inorder_boolean_return(root.right);
    }


    /*
    TC : O(logN)
    SC : O(logN)
     */

    /**
     * Iterative solution for inorder traversal
     */
    TreeNode prev2 = null;

    public boolean isValidBST_inorder_iterative(TreeNode root) {

        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }


            root = stack.pop();

            if (prev2 != null && prev2.val >= root.val)
                return false;
            prev2 = root;
            root = root.right;
        }
        return true;
    }
}

