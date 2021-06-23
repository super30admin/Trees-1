// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes

class IsValidBST{
    /*
    * Iterative
    * */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root != null){
         while(root!=null){
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

    /*Recursive*/
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        result = true;
        helper(root);
        return result;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            result = false;
            return;
        }
        prev = root;
        helper(root.right);
    }
}