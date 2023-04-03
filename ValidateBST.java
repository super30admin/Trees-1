/**
 * Time Complexity - O(N)
 * Space Complexity - O(H), where H is the height of the tree.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //iterative preorder.
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Integer prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev >= root.val)
                return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
