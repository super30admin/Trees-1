/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    //Recursive - Time- O(n), Space - O(h) - hight of tree(worst case O(n))
    boolean isValid;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        //stack.pop
        if (prev != null && prev.val >= root.val) {
            isValid = false;
        }
        prev = root;
        inorder(root.right);
    }
    // Inorder traversal
    //     public boolean isValidBST(TreeNode root) {
    //         TreeNode prev =  null;
    //         Stack<TreeNode> st = new Stack();
    //         while(root!= null || !st.isEmpty()){
    //             while(root!=null){
    //                 st.push(root);
    //                 root = root.left;
    //             }

    //             root = st.pop();
    //             if(prev!= null && prev.val>=root.val) return false;
    //             prev = root;
    //             root = root.right;
    //         }
    //         return true;
    //     }
}
