// Time Complexity : O(n)
// Space Complexity : O(1) if considering recursion stack space, then O(h) (h = height of the tree)
// Did this code successfully run on Leetcode : YES
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

/**
 * We can validate a BST by performing an inorder traversal on the tree. A valid BST should
 * give a sorted array in ascending order. Because it's a property that an inorder traversal
 * on a valid BST is sorted without any exception

 * Approach 1 - We can have a list to store the nodes traversed by the inorder traversal
 * and iterate over it to check if it is sorted. If yes, return true else false. This will
 * take an auxiliary space.

 * Approach 2 - To save on the extra space, use pointers while doing the inorder traversal.
 * Have a prev (null first) pointer and the current (root) pointer and have a flag to catch the
 * breach. If the flag is false, don't go further. This will save us from traversing after
 * catching the breach.
 *
 */


public class Problem1 {



    TreeNode prev;
    private boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        //base
        if (root == null) return;

        //logic
        if (flag) {
            inorder(root.left);

            if (prev != null && prev.val >= root.val) {
                flag = false;
            }
            prev = root;
            inorder(root.right);
        }

    }
}
