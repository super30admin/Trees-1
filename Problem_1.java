
// Time: O(nodes)
//Space: O(depth)


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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
          return true;
        }
      
      //Using iterative inorder traversal
      TreeNode prev = null;
      
      Stack<TreeNode> stack = new Stack<>();
      
      while(!stack.isEmpty() || root != null){ //2nd condition, only for inorder, as the stack is empty in the beginning
        
        //
        while(root != null){
          stack.push(root);
          root = root.left; //push everything in the left all the way till leaf to stack
        }
        
        //process the left
        TreeNode curr = stack.pop();
        
        //process the curr here (which is root)
        // System.out.print(curr.val+" "); // prints inorder traversal
        
        if(prev != null && prev.val >= curr.val){
          return false;
        }
        
        prev = curr; // update prev
        
        
        //go to the right now
        root = curr.right;
        
        
      }
        return true;
    }
}
