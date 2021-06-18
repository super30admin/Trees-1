// Time Complexity : O(n) in both recursive and iterative, since we are touching each node once
// Space Complexity : O(h) in recursive and O(1) in iterative
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
Inorder approch
1. we keep pushing nodes to the stack and keep moving to left until we hit a null on the left side.
2. we pop left most node from the stack when we hit a null in the left side;
3. before going to right we pop the root
4. when we reach right, since root is not null it will again hit null on the left side

To Validate a BST
1. We maintain a previous node that is at the global scope since any change would be reflected to all nodes in the stack.
2. anytime a node gets popped and if the previous node is not null, we compare it with the current node.
3.if previous node's value is greater than current popped node's value then we return false

*/

public class ValidateBST{
    
    /*public boolean isValidBST(TreeNode root) {
         Stack<TreeNode> stack=new Stack<>();
         TreeNode prev=null;
         while(root!=null||!stack.isEmpty())
         {
             while(root!=null)
             {
                 stack.push(root);
                 root=root.left;
             }
             root=stack.pop();
             if(prev!=null && prev.val>=root.val)
                 return false;
             prev=root;
             root=root.right;
         }
         
         return true;
     }*/
     TreeNode prev=null;
     public boolean isValidBST(TreeNode root) {
         
         if(root==null)return true;
         
         boolean case1= isValidBST(root.left);
         if(prev!=null && prev.val>=root.val)
             return false;
         prev=root;
         boolean case2=isValidBST(root.right);
         
         return case1 && case2;
     }
}