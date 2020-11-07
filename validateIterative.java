//Time complexity: O(n)
//Space complexity: It should be O(h), where h is the height of the tree. Here, a iterative solution is used. But even here the stack used has a maximum of h number of elements at once
//Program ran successfully
/*
    Algorithm: 1. Do inorder traversal of the tree
               2. Keep a track of the previous element
               3. Check if the previous element is smaller than the current element
               This is an iterative approach
*/
class validateIterative {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}
