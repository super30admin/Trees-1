// Definition for a binary tree node.


class validBinarySearchTree {
    //Using global variables vs local variable will have issue during stack.pop in recursion.
    //Intially prev = null and isValid = false
    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        isValid = true;
        inorder(root);
        return isValid;
    }

    //recursive function
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        //processing
        //need to check prev with current val which is a really good optimization instead collecting everything and sorting at end to find the valid BST or not.
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}


//Using min and amx variables
class Solution {
    // Using global variables vs local variable will have issue during stack.pop in
    // recursion.
    // Intially prev = null and isValid = false
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        isValid = true;
        //comparing with min and max at every node to check if it's valid BST or not
        checkValidity(root, null, null);
        return isValid;
    }

    // recursive function
    //Using min and max we can do any type of DFS and we the code will run
    public void checkValidity(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return;
        }
        checkValidity(root.left, min, root.val);
        // processing
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            isValid = false;
            return;
        }
        checkValidity(root.right, root.val, max);
    }
}