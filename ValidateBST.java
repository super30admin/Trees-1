//TC = O(N)
// SC = O(H) where H is the height of the tree
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode prev = null;
        
        while(root != null || !st.isEmpty()){
            // equivalent to inorder(root.left)
            while(root != null){
                st.push(root);
                root = root.left;                
            }
            
            root = st.pop();
            
            if(prev != null && prev.val >= root.val) return false;            
            prev = root;
            
            // equivalent to inorder(root.right)
            root = root.right;
            
            
        }
        
        return true;

        
    }
}