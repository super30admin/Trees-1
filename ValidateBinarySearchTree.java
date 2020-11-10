package S30.Trees_1;


/*
Time Complexity : O(n)
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/


import java.util.Stack;

public class ValidateBinarySearchTree {

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

    TreeNode prev = null;
    public boolean isValidBSTIterative(TreeNode root) {

        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;

            root = root.right;

        }

        return true;

    }

    public boolean isValidBSTRecursive(TreeNode root) {

        if(root == null) return true;
        if(isValidBSTRecursive(root.left) == false) return false;

        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        return isValidBSTRecursive(root.right);
    }



    //Solution using maximum and minimum range values
    public boolean isValidBST(TreeNode root) {

        return validateBST(root,null,null);

    }

    public boolean validateBST(TreeNode root, Integer minVal, Integer maxVal){

        if(root == null) return true;
        if(minVal != null && root.val <= minVal) return false;
        if(maxVal != null && root.val >= maxVal) return false;

        return validateBST(root.left,minVal,root.val) && validateBST(root.right,root.val,maxVal);
    }


}
