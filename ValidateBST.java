// LC 98

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    public class TreeNode {
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

    /**
     * InOrder traversal of a BST == ascending order
     * <p>
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    public boolean isValidBST_brute(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        inorder_brute(root, inorder);
        /*
        Use 2-ptr approach to verify sorted order
         */
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1).val >= inorder.get(i).val) {
                return false;
            }
        }
        return true;
    }

    private void inorder_brute(TreeNode root, List<TreeNode> inorder) {
        if (root == null) {
            return;
        }
        inorder_brute(root.left, inorder);
        inorder.add(root);
        inorder_brute(root.right, inorder);
    }

    /**
     * Implement inorder traversal 2-ptr approach on the fly using a prev and curr (root) ptr
     * <p>
     * TC: O(n)
     * SC: O(h)
     *
     * @param root
     * @return
     */
    public boolean isValidBST_better(TreeNode root) {
        return inorder_better(root, new TreeNode[]{null});
    }

    private boolean inorder_better(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return true;
        }
        boolean left = inorder_better(root.left, prev);
        if (!left) {
            return false;
        }
        if (prev[0] != null && prev[0].val >= root.val) {
            return false;
        }
        prev[0] = root;
        return inorder_better(root.right, prev);
    }

    /**
     * Root should be > the largest in the left subtree
     * and
     * Root should be < the smallest in the left subtree
     * <p>
     * i.e.,
     * <p>
     * specify ranges for each node
     * <p>
     * root = (long.min, long.max)
     * root.left = (long.min, root)
     * root.right = (root, long.max)
     * <p>
     * TC: O(n)
     * SC: O(h)
     * h == n for a skewed tree
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        /*
        Use Long min max to support Int min max values
         */
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (min >= root.val || max <= root.val) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
