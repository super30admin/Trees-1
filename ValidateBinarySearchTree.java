//Time Complexity: O(N)
//Space Complexity: O(H)


class Solution {
    public boolean isValidBST(TreeNode root) {
       Integer pre = null;
    Stack<TreeNode> stack = new Stack<>();
    while (true) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        if (stack.isEmpty()) {
            return true;
        }
        TreeNode node = stack.pop();
        if (pre != null && pre >= node.val) {
            return false;
        }
        pre = node.val;
        root = node.right;
    }
    }
}
