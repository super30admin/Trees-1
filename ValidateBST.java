public class ValidateBST {
    static TreeNode prev = null;
    public static boolean isValidBST(TreeNode root) { //O(n) T.C, O(1) S.C
        if(root == null) return true; //if null value encountered, go back to previous recursive function

        boolean left = isValidBST(root.left); //recursive call on left child

        if((prev != null) && root.val <= prev.val) return false; //check if values are sorted
        prev = root; //update prev to current for next recursive function

        boolean right = false;
        if(left) right = isValidBST(root.right); //only proceed if left is true
        return left&&right; //It is binary only if both left and right are sorted
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println("Is the given input a BST: " + isValidBST(root));
    }
}
