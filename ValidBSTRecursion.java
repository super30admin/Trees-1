package Tree1;

/*S30 Big N Problem #41 {Medium} - https://www.youtube.com/watch?v=mwzKeVZmRik
   
    You are given a binary tree, and you have to check whether its a binary search tree or not.
    you may assume that BST can be defined as follows: 

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:

       5
       / \
      1   4
         / \
        3   6
   
        Input: [5,1,4,null,null,3,6]
        Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.
    Source Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
        -------------------------------------------------------------------------------------------------------
        Time complexity : o(n) - n is the number of elements in tree
        space complexity: o(h) - Height of the tree. At any given time,there will H nodes inside my recursive stack.
        Did this code run successfully in leetcode : yes
        problems faces : no
        */

public class ValidBSTRecursion {

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {

        return inorder(root);
    }

    public  boolean inorder(TreeNode root)
            {
                //base
                    if(root == null) return true;
                    if(inorder(root.left) == false) return false;    
                    System.out.println(root);
                    if (prev != null && prev.val >= root.val)  return false;
                    prev = root;

                   return  inorder(root.right);
            }

    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
