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
// Recursive function - checking if at any current node whether it is greater than left child and less than right child
// TC: O(N)
// SC: O(H) -> height of the tree
class Solution {
     public boolean isValidBST(TreeNode root) {
          return helper(root, null, null);
      }
       private boolean helper(TreeNode root, Integer min, Integer max)
       {
           if (root == null)
              return true;
           if (min!= null && root.val <= min )
               return false;
           if (max!= null && root.val >= max )
               return false;
  // when checking on the left side of root, the min will change but max remains root.val as on the left side, elements will be < cuurent root's val. So keep max fixed as root.val and update min
  // when checking on the right side of root, the max will change but min remains root.val as on the right side, elements will be > cuurent root's val. So keep min fixed as root.val as update max
           return helper(root.left, min, root.val) && helper(root.right, root.val, max);
       }
    }


// Recursive function with void as return type -- using inorder traversal
// TC: O(N)
// SC: O(H) -> height of the tree
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     TreeNode prev;
//     boolean isValid;
//      public boolean isValidBST(TreeNode root) {
//             if ( root == null )
//                 return true;         
//             isValid = true;
//             inorder(root);   
//             return isValid;
//         }
//       private void inorder(TreeNode root)
//       {
//           //base case
//           if (root == null)
//               return; 
          
//           //logic
//            inorder(root.left);
              
//           //stack.pop() happens when left most node of that subtree is reached
//           if (prev != null && prev.val >= root.val)
//           { 
//               isValid = false;
//               return;
//           }
//           prev = root;
//           inorder(root.right);    
//       }
//     }


// Recursive function with boolean as return type - using inorder traversal
// TC: O(N)
// SC: O(H) -> height of the tree
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     TreeNode prev = null;
//      public boolean isValidBST(TreeNode root) {
//             if ( root == null )
//                 return true;
//             return inorder(root);      
//         }
//       private boolean inorder(TreeNode root)
//       {
//           //base case
//           if (root == null)
//               return true; 
          
//           //logic
//           if (!inorder(root.left)) 
//               return false;
              
//           //stack.pop() happens when left most node of that subtree is reached
//           if (prev != null && prev.val >= root.val)
//               return false;
//           prev = root;
//           return inorder(root.right);    
//       }
//     }

// Iterative  - using inorder traversal
// TC: O(N)
// SC: O(H) -> height of the tree
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null)
//            return true;
//         Stack<TreeNode> stack = new Stack();
//         TreeNode prev = null;
//         while ( root != null || !stack.isEmpty())
//         {
//             while ( root != null)
//             {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//            if ( prev != null && prev.val >= root.val)
//                 return false;
//             prev = root;
//             root = root.right;
//         }
//         return true;
//     }      
// }
