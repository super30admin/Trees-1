/**
Problem: https://leetcode.com/problems/validate-binary-search-tree/
TC: O(n) where n is the total number of nodes in the tree
SC: O(h) for recursion stack where h = max height of tree. This would have been log n if the tree was a balanced binary search tree
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
class Solution {

    /**
        Approach 1 : Inorder traversal and store the values in an array. The resulting array should be sorted in ascending order.
        We can check that the array is in asc order by comparing consecutive elements.

        Approach 2: Iterative with prev pointer
        The prev pointer would always point to a node and we would compare every node in its right subtree to ensure it is bigger than prev.
        Comparing prev and cur pointers is analogous to comparing consecutive elements in approach 1.
    */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                if (prev != null && prev.val >= cur.val) {
                    return false;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        return true;
    }
    
    /**
        Approach 3: Recursive with prev pointer
    */
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }
    
    private boolean inorderTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!inorderTraversal(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return inorderTraversal(root.right);
    }
    
    /**
        pproach 4: Recursive with min-max values
    */
    public boolean isValidBST(TreeNode root) {
        // can use null also instead of min and max
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        
        return (
            (min < root.val && root.val < max) &&
            isValidBST(root.left, min, root.val) &&
            isValidBST(root.right, root.val, max)
        );
    }
}