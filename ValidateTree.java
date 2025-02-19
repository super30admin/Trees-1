// Overall Time Complexity : O(n) . The time taken to iterate over all the nodes in the linked list.
// Overall Space Complexity : O(n) . The space complexity is 0(n) because of the stack size used by recursion calls (for skewed trees).
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation



// Using Inorder traversal check if the left subtree(all nodes) is less than the parent.
// Recursively  check for right subtree are greater then the parent 

class ValidateTree {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }
    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        if(prev!=null && prev.val>=root.val){
            flag = false;
            
        }   
        prev = root;
        if (flag) helper(root.right);

    }
}