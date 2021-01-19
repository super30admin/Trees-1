// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : some difficulty with understanding recursion


// Your code here along with comments explaining your approach
//We will use inorder traversal to go through the tree. In order to check if it is a
//valid BST we need to make sure the traversal goes in increasing order, so we check if the previous
//node is less than the current node


public class ValidBST {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        //iterative
//        if(root == null) return true;
//        Stack <TreeNode> st = new Stack<>();
//        //TreeNode prev = null;
//        while(root != null || !st.isEmpty()){
//            while(root != null){
//                st.push(root);
//                root = root.left;
//            }
//
//            root = st.pop();
//            if(prev != null && prev.val >= root.val) return false;
//            prev = root;
//            root = root.right;
//        }
//
//        return true;


        //recursive
        if(root == null) return true;

        return inorder(root);

    }
    //recursive

    //inorder traversal(left, root, right)
    public boolean inorder(TreeNode root){
        if(root == null) return true;

        //if the check below is false
        if(inorder(root.left) == false) return false;

        //if the previous root in traversal is bigger than current
        if(prev != null && prev.val >= root.val ){
            return false;
        }
        prev = root;
        return inorder(root.right);
    }
}