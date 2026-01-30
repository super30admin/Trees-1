 // Solution -1 
 
 // TimeComplexity: O(n) where n is number of nodes
 // SpaceComplexity: O(h) where h is height of the tree
 // Explanation : During inorder traversal, I track the previously visited node. Because inorder traversal of a BST produces values in sorted order, any case where the previous value is greater than or equal to the current value indicates the tree is invalid, and I immediately return false.
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
        
    }
    private boolean helper(TreeNode root) {
        //base
        if(root == null) return true;

        // logic
        if(!helper(root.left)) return false;
        if(prev!=null){if(root.val<= prev.val)return false;}
        prev = root;
        return helper(root.right);
    }
}
 
 // Solution -2 
 
 // TimeComplexity: O(n) where n is number of nodes
 // SpaceComplexity: O(h) where h is height of the tree
 // Explanation : I traverse the tree using DFS. For each node, I maintain the valid range (min, max) that its value is allowed to have based on BST properties. If the current node’s value is not within this range, I set the flag to false, meaning the tree is not a valid BST.The left subtree is recursively checked with an updated maximum bound (root.val), and the right subtree is checked with an updated minimum bound (root.val).If all nodes satisfy their constraints, the tree is a valid BST.
class Solution {
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return flag;
        
    }
    private void helper(TreeNode root, long min, long max) {
        //base
        if(root == null) return;
        // logic
        if(min>= root.val || max<= root.val) {
            flag = false;
        }
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}