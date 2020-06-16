//Time Complexity:O(n)
//Space complexity:O(n)


class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st=new Stack();
        TreeNode prev=null;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && root.val<=prev.val){
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
    }
}