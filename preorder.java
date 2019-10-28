//preorder Traversal
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    public void helper(TreeNode node, ArrayList<Integer> res) {
        if (node != null) {
            res.add(node.val);
            if (node.left != null) {
                helper(node.left, res);
            }
          
            if (node.right != null) {
                helper(node.right, res);
            }
        }
    }
}
