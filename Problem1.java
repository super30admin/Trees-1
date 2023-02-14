/*
Validate BST
time: O(n)
space: O(height) or O(levels)

public class Problem1 {
    private void inorder(TreeNode root) {
        if(root==null) return;

        if(flag) inorder(root.left);

        if(prev!=null && prev.val>=root.val) {
            flag = false;
        }
        prev = root;

        if(flag) inorder(root.right);

    }

}
*/