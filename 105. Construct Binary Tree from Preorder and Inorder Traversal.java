class Solution {// time and space of O(n) discussion
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;
    Stack<TreeNode> s = new Stack<>();
    //TreeNode root = new TreeNode(preorder[0]), cur = root;
    TreeNode root = new TreeNode(preorder[0]); 
    TreeNode cur = root;
    for (int i = 1, j = 0; i < preorder.length; i++) {
        if (cur.val != inorder[j]) {
            cur.left = new TreeNode(preorder[i]);
            s.push(cur);
            cur = cur.left;
        } else {
            j++;
            while (!s.empty() && s.peek().val == inorder[j]) {
                cur = s.pop();
                j++;
            }
            cur = cur.right = new TreeNode(preorder[i]);
        }
    }
    return root;
  }
}