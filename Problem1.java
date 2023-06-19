package Trees1;
/**
 * 
 *  We do inorder traversal and at each point we check if the prev val in inorder traversal is always less than the current val. 
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
