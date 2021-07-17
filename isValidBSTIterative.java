// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

public class isValidBSTIterative {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;

        // keep iterating until stack is not empty or root is not null
        while(root != null || !stack.isEmpty()){
            // iterate left subtree
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            // pop topmost node
            root = stack.pop();

            // return false if previous root is greater than current
            if(prevNode != null && prevNode.val >= root.val)
                return false;

            prevNode = root;
            root = root.right;
        }
        return true;
    }
}