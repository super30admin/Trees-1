/**
 * LeetCode 98. Validate Binary Search Tree
 * Link: https://leetcode.com/problems/validate-binary-search-tree/description/
 */
//------------------------------------ Solution 1 -------------------------------------
public class ValidateBST {
    /**
     * Conditional void based recursion with global variable maintaining previous reference
     *
     * Time: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    TreeNode prev;
    boolean result;
    public boolean isValidBST(TreeNode root) {
        this.result = true;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        //base
        if (root == null || !result) {
            return;
        }

        //logic
        inOrder(root.left);
        //check value
        if (prev != null && root.val <= prev.val) {
            result= false;
        }
        prev = root;
        inOrder(root.right);
    }
}

//------------------------------------ Solution 2 -------------------------------------
class ValidateBST2 {
    /**
     * Conditional boolean based recursion with global variable maintaining previous reference
     *
     * Time: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root) {
        //base
        if (root == null) {
            return true;
        }

        //logic
        if (!inOrder(root.left)) {
            return false;
        }
        //check value
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;

        return inOrder(root.right);
    }
}

//------------------------------------ Solution 3 -------------------------------------
class ValidateBST3 {
    /**
     * Conditional void based recursion with Global variable checking permissible range of value at each node
     * Update the range's high to current root value while traversing left child/subtree
     * Update the range's low to current root value while traversing right child/subtree
     *
     * Time: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    boolean result;
    public boolean isValidBST(TreeNode root) {
        this.result = true;
        rangeCheck(root, null, null);
        return result;
    }

    private void rangeCheck(TreeNode root, Integer low, Integer high) {
        //base
        if (root == null) {
            return;
        }

        //logic
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            result = false;
        }

        if(result) {
            rangeCheck(root.left, low, root.val);
        }

        if(result) {
            rangeCheck(root.right, root.val, high);
        }
    }
}

//------------------------------------ Solution 4 -------------------------------------
class ValidateBST4 {
    /**
     * Conditional boolean based recursion checking permissible range of value at each node
     * Update the range's high to current root value while traversing left child/subtree
     * Update the range's low to current root value while traversing right child/subtree
     *
     * Time: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    public boolean isValidBST(TreeNode root) {
        return rangeCheck(root, null, null);
    }

    private boolean rangeCheck(TreeNode root, Integer low, Integer high) {
        //base
        if (root == null) {
            return true;
        }

        //logic
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        return rangeCheck(root.left, low, root.val) && rangeCheck(root.right, root.val, high);
    }
}