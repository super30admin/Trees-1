class Solution {
    public boolean isValidBST(TreeNode root) {

        TreeNode prev = null;

        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }

            prev = root;
            root = root.right;
        }

        return true;
    }
}

Time Complexity : O(n) - n is the number of nodes
Space Complexity : O(h) - h is the height of the tree.
