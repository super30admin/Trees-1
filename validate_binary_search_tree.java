// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity :O(n), where n is the height of the tree, to maintain stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Three liner explanation in plain english:
//1. Maintain a stack and starting from the root node traverse and push all its left childs till the last node(leaf) is pushed in the stack
//2. Then pop the last node pushed in the stack and  check if its previous node is smaller than the current node 
//3. Assign the current node to the currents right and again check for all its left childs continue doing this till the current node is null OR the stack is empty 

// Your code here along with comments explaining your approach

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
class Solution {
    public boolean isValidBST(TreeNode root) {  
        
        //create a stack to maintain the order of the nodes while traversing
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null ||!stack.isEmpty()){
            //add all the left childs of a node, till the leaf node
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            //once the leaf node is done traversing, pop it from the stack
            root = stack.pop();
            //In BST, the previous node should be smaller than the current node
            if(prev !=null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
            
        }
        //return true, if the above rules are satisfied
        return true;
    }
}