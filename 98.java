class Solution {
    
    boolean answer = true;
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return answer;
    }
    public void inorder(TreeNode root){
        if(root == null) return ;
        /*
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root != null){
            st.push(root);
            root = root.left;
        }*/
        inorder(root.left);
        
        //root=st.pop();
        //System.out.println(root.val);
        
        if(prev != null && prev.val >= root.val){
            answer =  false;
            return;
        }
        prev = root;
        
        //root=root.right;
        
        inorder(root.right);
    
    return ;
}
}



class Solution {
    
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !st.isEmpty()){
            while(root != null){
            st.push(root);
            root = root.left;
        }
        root=st.pop();
        //System.out.println(root.val);
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        root=root.right;
    }
    return true;
}
}



