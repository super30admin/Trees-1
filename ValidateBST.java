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
//Time Complexity : O(n)
//Space Complexity : O(n)

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;

    }

class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
        
    }
}


//Recursive solution:
    TreeNode prev = null;
    public boolean isValidBST1(TreeNode root){
        return inorder(root);

    }
    
    private boolean inorder(TreeNode root){
        prev = null;
        if(root == null){
            return true;
        }
        if(inorder(root.left) == false){
            return false;
        }
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        return inorder(root.right);
    }
    
}
