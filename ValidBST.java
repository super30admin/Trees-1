// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(H). H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean isValidBST(TreeNode root) {
       return binaryTree(root);
    }
    
    private boolean binaryTree(TreeNode root){
        if(root==null) return true;
        Stack<TreeNode>stack = new Stack();
        TreeNode prevNode = null;
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prevNode!=null && root.val<=prevNode.val) return false;
            prevNode=root;
            root=root.right;
        }
        return true;
        
    }
}
