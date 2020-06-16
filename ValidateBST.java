import java.util.Stack;

/*
    
    Time Complexity : O(N)
    Space Complexity :  No Extra Space Recursive space O(H) H is the height of the tree
    Is worked on leetcode : YES

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
public class ValidateBST {

    TreeNode prev_node;
    public boolean isValidBST_Recursive(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if (root == null )return true;
        
//         left subtree
//         if left subtree is not valid BST retunr false
        if( inorder(root.left) == false) return false;
//         check if root is less than or not if it is less than return false
        if(prev_node != null && root.val <= prev_node.val ) return false;
        
        prev_node = root;
//         right subtree
        return inorder(root.right);
        
    }
    public boolean isValidBST_Iterative_InorderSolution(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode prev_node=null;
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev_node != null  && root.val <= prev_node.val) return false;
            prev_node = root;
            root = root.right;
        }
        return true;
        
    }
}
