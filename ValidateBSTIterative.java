// TC: O(n)
// SC: O(h)
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}