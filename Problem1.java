package Trees1;
/**
 * 
 * We do know the the last element of postorder array is always the current root and we can deduce span of left and right subtree using inorder array.
 * We use pointers to vary the low and high of both arrays and recursively construct first the right subtree and then the left subtree using the corresponding inorder and preorder arrays.
 * 
 * Time Complexity :
 * O(n) - where n is the no of nodes.
 * 
 * Space Complexity :
 * O(n), actually is the height of the tree in worst case(skewed tree)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
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

public class Problem1 {
    TreeNode prev=null;
    TreeNode curr=null;
    boolean flag=true;
   
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null)
            return true;
        inOrder(root);
        return flag;

    }

    private void inOrder(TreeNode node){
        //base
        if(node==null)
            return;
        //logic
        if(flag)
            inOrder(node.left);
        prev=curr;
        curr=node;
        if(prev!=null){
            if(prev.val>=curr.val)
                flag=false;
        }
        if(flag)
            inOrder(node.right);
    }

}
