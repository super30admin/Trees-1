// Time Complexity :  O(N) - Number of nodes in BST
// Space Complexity : O(h) - H is height of the BST. H nodes will be in the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// We can do inorder traversal, which returns the values in sorted manner. Store them in temporary list and compare
// each value. If the values are not in increasing order, we return it as invalid BST. We can optimize for reduce
// extra space used.
// We can keep prev node that points to the node that was just visited before the current node. And these two can be compared.
// At a point, the prev points to rightmost child on the left subtree of a root and should be compared to the root.
// If prev.val is greater than the root val, they are not in increasing order, thus return false.

// Similarly, the root should be compared to the leftmost node on the right subtree, if the root value(prev) is
// greater the current node, we should return false.
import java.util.ArrayList;

public class ValidateBST {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if(root == null) return true;
        boolean left = inorderTraversal(root.left);
        if(prev != null && root.val >= prev.val) return false;

        prev = root;
        boolean right = inorderTraversal(root.right);
        return left && right;
    }


    public boolean isValidBSTWithExtraSpace(TreeNode root) {
        ArrayList<Integer> temp = new ArrayList<>();

        inorderTraversal(root, temp);
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) >= temp.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> temp) {
        if (root == null) return;

        inorderTraversal(root.left, temp);
        // In order traversal, add root value to temp list
        temp.add(root.val);
        inorderTraversal(root.right, temp);
    }


}


