/**
Problem: Validate BST
Time Complexity :  O(n), where n is the number of nodes in the tree
Space Complexity : O(h), where h is the height of the tree

Did the problem run on LeetCode : Yes

Approach 1 : Inorder traversal(Iterative Solution)
1. Do the inorder traversal of the tree
2. If the elements are in increasing order in the inorder traversal, then we say that the tree is a BST, 
3. Otherwise, it's not.

Approach 2: Inorder traversal(Recursive Solution)

Approach 3: Leverage the property of BST, and make use of min and max
1. Check if the left child is lesser than the root, and the right child is greater than the root.
2. At any point, on the left subtree, the root will have the same minimum and the maximum will be the value of it's parent.
3. For the right subtree, the root will have the same maximum and the minimum will be the value of it's parent.

 */

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

//Approach 1: Iterative Solution 
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty() ) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

//Approach 2 : Recursive Solution
class Solution {
    TreeNode prev = null; //instance variable
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        return inorder(root);
    }
    public boolean inorder(TreeNode root) {
        if(root == null) return true;
        if(inorder(root.left) == false) return false;
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return inorder(root.right);
        
    }
}

//Approach 3 : 
class Solution {
    TreeNode prev = null; //instance variable
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    public boolean validate(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if((max!= null && root.val >= max) || (min!=null && root.val <= min)) {
            return false;
        }
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
