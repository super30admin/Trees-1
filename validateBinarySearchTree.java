i/*
Time complexity - O(n)
Space complexity - Height of the tree. worst case O(n) if tree is unbalanced. 
while doing inorder traversal I will keep track of prev node. for every current node i wll be checking if cur node value if greater than its prev node value. If it is less than is predecessor then this is not a valid binary search tree. 
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        //edge case
        if(root == null)
            return true;
        TreeNode prev = null, cur = root;
        Stack<TreeNode> st = new Stack<>();
        while(cur != null || !st.isEmpty()){
            //push left subtree of cur node into stack go deeper in the left
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            //pop the cur node 
            cur = st.pop();
            //and check if its value if less than prev node. return false if this 
            if(prev != null && prev.val >= cur.val)
                return false;
            prev = cur;
            cur = cur.right;
        }
        return true;
    }
}
