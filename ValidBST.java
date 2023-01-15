// Time Complexity: O(n)
// Space complexity: O(H) height of tree

// Approach: 
// We know that for a valid BST, each subtree, root.left < root < root.right 
// The same carries on from entire tree from left to right.
// This follows a recurive pattern. Basically at each node we need to check if the previous node
// is smaller than the current node.
// Keep a previous TreeNode as global
// So we create a helper recursive function, traverse root.left, root.right
// We check if the previous is greater than the root then we return false
// To save some time, we can say if flag is true, then only execute root.right

class Solution {
    
    boolean flag;
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        flag=true;
        helper(root);
        return flag;
    }
    
    private void helper(TreeNode root){
        
        //base
        if(root==null) return;
            
        helper(root.left);
        
        // System.out.println("Up");
        // System.out.print(root.val);
        
            if(prev!=null && prev.val >= root.val){
                flag=false;
            }
        prev=root;
        
        if(flag) helper(root.right);
        
        // System.out.println("Down");
        // System.out.print(root.val);
    }
}