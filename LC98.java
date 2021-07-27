class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = null;
        TreeNode prev = null;
        
        //stack.add(root);
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            curr = stack.pop();
            if(prev != null && prev.val >= curr.val){
                return false;
            }
            prev = curr;
            root = curr.right;
        }
        return true;
    }
}

//Time : O(n)
//Space : O(n)