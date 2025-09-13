//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :Yes
//Approach: The elements are sorted if we perform an inorder traversal on a balanced BST
//at each step if we compare the current root.val with the prev.val, if root.val < prev.val , continue else return false
//why? because the left child's value should be < parent's val (prev in this case)
//we would need to take prev as a global variable because prev if taken as a parameter in the helper method each node will bring its own prev,
// but we don't want it to get overwritten for each node
public class ValidateBST {

    private TreeNode prev;

    public ValidateBST() {
        this.prev = null;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        //base case
        if (root == null) return true;

        if (!helper(root.left)) return false;
        if (prev != null && root.val <= prev.val) return false;
        prev = root;

        return helper(root.right);
    }

    public static void main(String[] args) {
        final ValidateBST validateBST = new ValidateBST();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);

        System.out.println(validateBST.isValidBST(node));
    }
}
