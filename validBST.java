/*
Author: Akhilesh Borgaonkar
Problem: LC 98. Validate Binary Search Tree (Trees-1)
Approach: Making use of the fact that inorder traversal of a tree will always be in the sorted increasing order for a valid BST. I am 
    traversing the given tree in inorder way and pushing it in stack. While pushing the node to the stack, I compare it with my previous
    node value to be less than current node value always.
Time Complexity: O(n) where n is number of nodes in the given tree
Space complexity: O(n) where n is number of nodes in the given tree
LC verified.
*/


class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val <= prev.val)
                return false;
            prev = root;
            root = root.right;
            
        }
        return true;
    }
    
}