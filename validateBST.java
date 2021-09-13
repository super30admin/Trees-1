// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
    class solution{
        public class TreeNode {
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
        // public boolean isValidateBST(TreeNode root) {
        //     Stack<TreeNode> st = new Stack<>();
        //     TreeNode prev = null;
        //     while(root != null || !st.isEmpty()){
        //         while(root != null){
        //             st.push(root);
        //             root = root.left;
        //         }
        //         root = st.pop();
        //         if(prev != null && prev.val >= root.val) return false;
        //         prev = root;
        //         System.out.println(root.val);
        //         root = root.right;
        //     }
        //     return true;
        // }
        boolean Result;
        TreeNode prev;
        public boolean isValidateBST(TreeNode root) {
            Result = true;
            inorder(root);
            return Result;
        }
    
        private void inorder(TreeNode root){
            if(root == null) return;
            inorder(root.left);
            System.out.println("Up");
            System.out.println(root.val);
            if(prev != null && prev.val >= root.val){
                Result = false;
                return;
            }
            prev = root;
            inorder(root.right);
            System.out.println("Down");
            System.out.println(root.val);
        }
    }