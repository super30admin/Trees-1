// Time Complexity : O(n) :  Traversing the every node once
// Space Complexity : O(n) (Depth of the tree (Worst case for Skew tree : O(n)))

class Solution {

    public boolean isValidBST(TreeNode root) {
        
        
        // Inorder Traversal : Iterative (using a new stack)
   
        Stack<TreeNode> stack =  new Stack<>();
        TreeNode prev = null;
        
        while (root != null || ! stack.isEmpty()){
            
            // Iterate through the left most node
            while (root != null){
                
                stack.push(root);
                root = root.left;
            }
            
            // Consider the left most sub tree and traverse the Inorder
            root = stack.pop();
            System.out.println(root);
            
            // Compare the new element with the previous element. 
            // If new is smaller, then it is not sorted.
            // Then it cannot be Binary Search Tree (BST)

            if (prev != null && prev.val >=  root.val){
                return false;
            }
            
            // For next iteration : Update the prev and root
            prev = root;
            root = root.right;
            
        }
    
        // Sorted Inorder Traversal always generates a Valid BST.
        return true;   
    }
    

}