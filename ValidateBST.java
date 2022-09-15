// TC: O(n) where n is the number of nodes
// SC: O(h) where h is the height of the tree

import java.util.Stack;

public class ValidateBST {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    // Approach 1 - recursive

    public static class Solution1 {
        TreeNode prev;
        boolean flag;
        public boolean isValidBST(TreeNode root){
            flag = true;
            inorder(root);
            return flag;
        }

        public void inorder(TreeNode root) {
            if (root == null) return;

            if (flag) {
                inorder(root.left);
            }
            // st.pop() = root;

            if (prev != null && prev.val >= root.val) {
                flag = false;
                return;
            }

            prev = root;

            if (flag) {
                inorder(root.right);
            }
            // st.pop() = root;
        }
    }

    // Approach 2 - Using pointer prev & recursive boolean function
    public static class Solution2 {
        TreeNode prev;
        public boolean isValidBST(TreeNode root){
            return inorder(root);
        }

        public boolean inorder(TreeNode root) {
            if (root == null) return true;
            System.out.println(root.val);

            boolean left = inorder(root.left);
            // st.pop() = root;

            if (prev != null && prev.val >= root.val) {
                return false;
            }

            prev = root;
            boolean right = inorder(root.right);
            // st.pop() = root;
            return left && right;
        }
    }


    // Approach 3 - Iterative
    public static class Solution3 {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> st = new Stack<>();
            TreeNode prev = null;
            while(root != null || !st.isEmpty()){
                while(root != null){
                    st.push(root);
                    root =  root.left;
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

    // Approach 4 - Limit
    public static class Solution4{
        boolean flag;
        public boolean isValidBST(TreeNode root) {
            flag = true;
            helper(root,null,null);
            return flag;
        }
        private void helper(TreeNode root,Integer min, Integer max){
            //base
            if(root == null)return;
            if(min != null && root.val <= min) flag = false;
            if(max != null && root.val >= max) flag = false;

            // logic
            if(flag) {   // stop traversal when flag is false
                helper(root.left, min, root.val);
                helper(root.right,root.val, max);
            }
        }
    }

}

