// Time Complexity : O(n) n-> no of nodes
// Space Complexity : O(h) h-> height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is to validate whether a given binary tree is a Binary Search Tree (BST).
// We do this by performing an in-order traversal iteratively using a stack.
// During in-order traversal, the values should appear in strictly increasing order.
// We keep track of the previous node, and if at any point the current node's value
// is not greater than the previous, we return false.


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}

    TreeNode(int val){
        this.val=val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class ValidateBST {
    public boolean solve(TreeNode root){
        TreeNode prev = null;
        if(root==null){
            return true;
        }
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            System.out.println(root.val);
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev=root;
            root=root.right;

        }
        return true;

    }
    
    public static void main(String[]args){
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        ValidateBST ob = new ValidateBST();
        System.out.println("Is valid BST? "+ob.solve(root1));

        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Is valid BST? "+ob.solve(root2));
    }
}