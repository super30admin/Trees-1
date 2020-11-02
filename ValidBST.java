/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //Recursive - Time- O(n), Space - O(h) - hight of tree(worst case O(n))
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }
    public boolean inOrder(TreeNode root){
        if(root == null) return true;
        if(!inOrder(root.left)) return false;

        if(prev!= null && prev.val>=root.val) return false;
        prev=root;
        return inOrder(root.right);
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