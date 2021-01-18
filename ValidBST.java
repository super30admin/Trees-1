// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//One property of the BST is it's inorder traversal is in ascending order.
//Find if the elements are in place by checking inorder traversal
//Traverse to the left most leaf by adding all the elements in the travel to the stack
//Once the left node is null, pop out the last element and check for the right node.
//If right node is present push to the stack and continue to pop out that element.
//while popping out check if the previous value is greater than current then return false (Not BST).

import java.util.;
class HelloWorld {
    public static class TreeNode {
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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        StackTreeNode st = new Stack();
        TreeNode prev = null;

        while(!st.isEmpty()  root!=null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            System.out.println(root.val);
            if(prev!=null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(hw.isValidBST(root));
    }

}