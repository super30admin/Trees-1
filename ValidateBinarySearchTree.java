//Time Complexity: O(h)
//Space Complexity: O(h)

public class ValidateBinarySearchTree {

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

    private Integer prev;

    public boolean isValidBST(TreeNode root) {

        prev = null;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root){

        //Base

        if(root==null){
            return true;
        }

        //Logic

        if(!inOrder(root.left)) return false;
        if(prev != null && root.val <= prev){
            return false;
        }

        prev = root.val;

        return inOrder(root.right);

    }
}
