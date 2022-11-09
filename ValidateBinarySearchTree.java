

// TC : O(n) // n = number of tree nodes
// SC : O(h) // height of tree


package S30_Codes.Trees_1;
import java.util.Stack;

 // Definition for a binary tree node.
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

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        long prevEle = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            // current
            if(prevEle >= node.val)
                return false;
            prevEle = node.val;

            // right
            node = node.right;

            //left
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return true;
    }
}