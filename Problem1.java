// Time - O(N)
// Space - O(N)

public class Problem1 {

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

    public static boolean isValid(TreeNode root, Integer low, Integer high){
        if (root == null) return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) return false;

        return isValid(root.right, root.val, null) && isValid(root.left, null, root.val);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null ,null);
    }

    public static void main(String[] args) {
        //System.out.println(isValidBST());
    }
}
