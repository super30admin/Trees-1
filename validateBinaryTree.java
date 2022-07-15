// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        inorder(root);
        return isValid;

    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            isValid = false;
        }
        prev = root;
        if (isValid) {
            inorder(root.right);
        }
    }
}

// ------------------using min and max------------------
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    // TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        // prev=null;
        isValid = true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        inorder(root, null, null);
        return isValid;

    }

    public void inorder(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return;
        }
        System.out.println("min and max is" + min + " and" + max);
        if (min != null && root.val <= min || max != null && root.val >= max) {
            isValid = false;
        }

        inorder(root.left, min, root.val);
        inorder(root.right, root.val, max);
    }
}

// -----------------ITERATIVE----------------------------
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean isValid = true;
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
        return true;
    }
}