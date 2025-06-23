/*
Time Complexity- O(n) where n is the number of nodes
Space Complexity- O(h) where h is the height of tree
 */
public class ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
            left = right = null;
        }
    }
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {

        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if(root == null) return true;

        if(!inorder(root.left)) return false;

        if(prev != null && root.val <= prev.val) return false;
        prev = root;

        return inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        /*
                5
              /   \
             1     7
                  / \
                 6   8
         */
        ValidateBST valid = new ValidateBST();
        System.out.println("Is tree valid? :" + valid.isValidBST(root));
    }
}
