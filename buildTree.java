/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public TreeNode buildTree(int[] preorderTraversal, int[] inorderTraversal) {
       if(preorderTraversal.length == 0) return null;

       TreeNode rootNode = new TreeNode(preorderTraversal[0]);
       int rootIndex = -1;

       for(int i = 0; i < inorderTraversal.length; i++) {
           if(inorderTraversal[i] == rootNode.val) {
               rootIndex = i;
               break;
           }    
       }

       int[] preLeftSubtree = Arrays.copyOfRange(preorderTraversal, 1, rootIndex + 1);
       int[] preRightSubtree = Arrays.copyOfRange(preorderTraversal, rootIndex + 1, preorderTraversal.length);
       int[] inLeftSubtree = Arrays.copyOfRange(inorderTraversal, 0, rootIndex);
       int[] inRightSubtree = Arrays.copyOfRange(inorderTraversal, rootIndex + 1, inorderTraversal.length);

       rootNode.left =buildTree(preLeftSubtree, inLeftSubtree);
       rootNode.right = buildTree(preRightSubtree, inRightSubtree);
       
       return rootNode;
   }
}
