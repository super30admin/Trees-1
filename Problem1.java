public class Problem1 {
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
//    TC and SC for all the solution
//    TC : O(n)
//    Sc : O(h) where h = height of tree
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Stack<TreeNode> s = new Stack<>();
            TreeNode prev = null;
            while (root != null || !s.isEmpty()) {
                while (root != null) {
                    System.out.println("Adding value " + root.val);
                    s.push(root);
                    root = root.left;
                }
                root = s.pop();
                System.out.println("root pop value " + root.val);
                if (prev != null) {
                    System.out.println("prev value " + prev.val);
                }
                System.out.println("******");
                if (prev != null && prev.val >= root.val) return false;
                prev = root;
                root = root.right;
            }
            return true;
        }
    }

    //Recursion
    class Solution2 {
        Boolean isValid;
        TreeNode prev = null;
        public boolean isValidBST(TreeNode root) {
            isValid = true;
            inOrder(root);
            return isValid;
        }
        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            if (prev != null && prev.val >= root.val) {
                isValid = false;
            }
            prev = root;
            inOrder(root.right);
        }
    }
    //recursion with additional boolean check on left node
    class Solution3 {
        TreeNode prev = null;
        public boolean isValidBST(TreeNode root) {
            return inOrder(root);
        }
        private Boolean inOrder(TreeNode root){
            if (root == null ) return true;
            if (inOrder(root.left) == false){
                return false;
            }
            if (prev != null && prev.val >= root.val ){
                return false;
            }
            prev = root;
            return inOrder(root.right);
        }
    }
    //solution with min and max
    class Solution4 {
        TreeNode prev = null;
        public boolean isValidBST(TreeNode root) {
            return inOrder(root, null, null);
        }
        private boolean inOrder(TreeNode root, Integer min, Integer max){
            if (root == null) return true;
            if (min != null && root.val <= min) return false;
            if (max != null && root.val >= max) return false;

            boolean case1 = inOrder(root.left, min, root.val );
            boolean case2 = inOrder (root.right, root.val, max );
            return case1 && case2;
        }
    }
}
