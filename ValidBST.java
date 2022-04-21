import java.util.Stack;

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

public class ValidBST {
    // TC- O(n) n- number rof nodes in BST
    // SC- O(n)
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev=null;

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }

        return true;
    }
}
