import java.util.ArrayList;
import java.util.List;
//Time Complexity: O(n); n = #nodes
//Space Complexity: O(n)
class TreeNode {
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
public class ValidateBST {

    List<Integer> inorder = new ArrayList<>();;
    public boolean isValidBST(TreeNode root) {
        findInorder(root);
        int i = inorder.size() - 1;
        while (i > 0 ) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
            i--;
        }
        return true;
    }
    private void findInorder(TreeNode root) {

        if (root == null) return;

        findInorder(root.left);
        inorder.add(root.val);
        findInorder(root.right);

    }
}
