// Space complexity - O(1)
// Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
//The problem can be approached recursively and iteratively.
//Case1 Iterative approach
//Case2 recursive approach
//The important thing in this program is a prev pointer which is kind of slow pointer which keeps track of the previous root. If at any time, the BST tree condition is violated, we return false
//Inorder traversal is used which basically means the tree nodes values should be in ascending order
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){return false;}
        
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !s1.isEmpty()){
            
            while(root != null){
                
                s1.add(root);
                root = root.left;
            }
            
            root = s1.pop();
            
            if(prev != null && prev.val >= root.val){
                
                return false;
            }
            
            prev = root;
            root = root.right;
            
        }
        
        return true;
        
    }
}

// Space complexity - O(1)
//Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        return inorderValid(root);
        
        
    }
    
    private boolean inorderValid(TreeNode root){
        
        if(root == null){
            return true;
        }
        
        
       
        if(inorderValid(root.left) == false){return false;} ;
        if(prev != null && prev.val >= root.val){
            
            return false;
        }
         prev = root;
       if(inorderValid(root.right) == false){return false;} ;
        
        return true;
        
        
    }
}