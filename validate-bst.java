// Time - O(N)
// Space - O(N)
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null;
        
        while(root!=null || !s.isEmpty()) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && (prev.val >= root.val || prev.val >= root.val)) {
                return false;
            }
            prev = root;
            
            root = root.right;
            
        }
        return true;
    }
}
