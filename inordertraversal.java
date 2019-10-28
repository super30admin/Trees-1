//Inorder Traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    public void helper(TreeNode node, ArrayList<Integer> res) {
        if (node != null) {
            if (node.left != null) {
                helper(node.left, res);
            }
            res.add(node.val);
            if (node.right != null) {
                helper(node.right, res);
            }
        }
    }
}
