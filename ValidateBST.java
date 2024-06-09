import java.util.*;
import javax.swing.tree.TreeNode;
 //Time Complexity - O(n)
 //Space Complexity -O(n)
 //Approach - Take the inorder traversal of the tree. It will be in ascending order, if this constraint is affected such that the previous node is greater than the current node then it is not a valid BST.
 class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;

        }
       return true; 
    }
}

// RECURSION APPROACH
// class Solution {
//     TreeNode prev;
//     boolean isValid;
//     public boolean isValidBST(TreeNode root) {
//         isValid = true;
//         if(root == null){
//             return isValid;
//         }
//         prev = null;
//         inorder(root);
//         return isValid;
//     }
//     private void inorder(TreeNode root){
//         if(root == null){
//             return;
//         }
//         inorder(root.left);
//         if(prev != null && prev.val >= root.val){
//             isValid = false;
//             return;

//         }
//         prev = root;
//         inorder(root.right);
//     }
// }