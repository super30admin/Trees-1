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

    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {

        flag = true;

        helper(root);
        return flag;


        
    }

    private void helper(TreeNode root){
      if(root == null || !flag) return;

      if(flag){
       helper(root.left);

      //st.pop() will happen

      if(prev != null && prev.val >= root.val){
          flag = false;
          return;
      }

      prev = root;

      System.out.println("up" + root.val);

      }


      
      if(flag){
          helper(root.right);

      //st.pop();

      System.out.println("down" + root.val);

      }
      

    }
}

/*** 

Explanation : 

In BruteForce : To validate Binary Tree without checking its left and right, we can checck using Inorder Traversal. Inorder Travesal should be in Ascending order.

LEARNED TYPES OF TRAVERSALS THGT WE HAVE IN TREE

Preorer - "Root", Left, Right

Inorder - Left, "Root", "Right"

Postorder - Left, Right, "Root"

LEARNED BASIC RECURSION

Rules :

1) Before going to the children, append parent inside stack.
2) When It starts unfolding, it will unflod which are in stack.
3) After returing, st.pop() will happen which is not seen.


TC: Travelling to all the nodes. So its O(n).


SC: O(H) :

 Because, We have two types of Binary Search Tree's. 

               1) Complete Binary Tree - its O(logn) - because, At a time only half of the Binary Tree will go inside stack.
                  After coming out of all the nodes. Another side of the nodes will go inside stack
               2) Skewed Binary Tree - its O(n) - because, Skewed Binary Tree contains only half side. So, all the nodes are     going insde stack.
*/
