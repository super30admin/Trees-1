class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;    
            }
            root = s.pop();
            System.out.println(root.val);
            root = root.right;
        }
        return true;
    }
}