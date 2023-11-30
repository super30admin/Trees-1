//Time Complexity:O(n)
//Space Complexity:O(h) - h - height of tree
class Solution {
    /*
    
    Recursive approach
    
    TreeNode prev;
    boolean isBst = true;
    public boolean isValidBST(TreeNode root) {
       inOrder(root);
       return isBst;
    }

    private void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        if(prev!=null && prev.val >= root.val)
            isBst = false;
        prev=root;
        inOrder(root.right);
        
    }*/

    //Iterative approach

    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        Stack<TreeNode> st = new Stack<>();
        boolean flag = false;

        while(!st.isEmpty() || root != null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val >= root.val){
                return false;
            }
            System.out.println(root.val);
            prev = root;
            root = root.right;

        }
        return true;
    }
}