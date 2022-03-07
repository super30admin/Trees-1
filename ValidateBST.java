// Time Complexity : O(n) ~ O(h) h - height of tree because if skewed then worst case visit all nodes
// Space Complexity : O(n) function stack size; depth of tree nodes. If no function stack size considered then O(1) for constant variables
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/652602545/)
// Any problem you faced while coding this : No
// My Notes : Approach 1 : Using recursive using refference to a prev value.

class Solution {
    TreeNode prev = null;
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return result;
    }
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left); // 1
        if(prev!=null && prev.val>=root.val){
            result = false;
        }
        // Storing node as prev before visiting right node
        prev = root; // 2
        inorder(root.right); //3
    }
}

// Time Complexity : O(h) height of tree, if skewed then worst case iterate all
// Space Complexity : O(n) Using List addition for storign all nodes 
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 
// My Notes :  Approach 2 : Using recursive iterative and using list.

class Solution {
    // If you can check the inorder predecessor 
     
     private List<Integer> inorderList;
     public boolean isValidBST(TreeNode root) {
         inorderList = new ArrayList<Integer>();
         inorder(root);
         System.out.println("List : " +inorderList);
         boolean isAsc = true;
         if(inorderList.size()>1){
             for(int i = 1; i<inorderList.size();i++){
                 int curr = inorderList.get(i);
                 int prev = inorderList.get(i-1);
                 if(curr<=prev){
                     return false;
                 }
             }
         }
         if(inorderList.size() == 1){
             return true;
         }
        
         return isAsc;
     }
     
     private void inorder(TreeNode root){
         if(root == null){
             return;
         }
         inorder(root.left);
         inorderList.add(root.val);
         inorder(root.right);
     }
 }
