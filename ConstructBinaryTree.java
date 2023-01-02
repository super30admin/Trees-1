// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
 
import java.util.Arrays;

public class ConstructBinaryTree {

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


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = -1;
        for (int i =0; i <inorder.length;i++){
            if (inorder[i] == preorder[0]){
                rootIdx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx );
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length +1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length +1 , preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
        
    }

}
