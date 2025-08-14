//Time complexity: O(n)
//space complexity: O(h)

//we use prev pointer to keep track of the last visited node 

class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode root){
        if(root==null) return true; //base case

        boolean left=helper(root.left);
        if(left==false) return false;          //when breach stop the traversal

        //check if the current node is greater than the previous node
        if(prev!=null && prev.val>=root.val)
            return false;
        prev=root;              //update the previous node

        boolean right=helper(root.right);

        return left && right;
    }
}