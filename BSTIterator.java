/**
Problem: https://leetcode.com/problems/binary-search-tree-iterator/
*/

// Approach 1: Flatten with inorder traversal
// TC: O(n)
// SC: O(n)
class BSTIterator {

    List<TreeNode> nodes = null;
    int currentIndex = 0;
    
    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<TreeNode>();
        inorderTraversal(root);
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        
        inorderTraversal(root.left);
        nodes.add(root);
        inorderTraversal(root.right);
    }
    
    public int next() {
        if (hasNext()) {
            TreeNode n = nodes.get(currentIndex++);
            return n.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        if (currentIndex <= nodes.size() - 1) {
            return true;
        }
        return false;
    }
}

// Approach 2: Controlled recursion
// TC: O(1) -> amortized time = O(1)
// SC: O(n)
class BSTIterator {

    Stack<TreeNode> st = null;
    
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        populateStack(root);
    }
    
    private void populateStack(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode pop = st.pop();
        if (pop.right != null) {
            populateStack(pop.right);
        }
        return pop.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
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
 *
 *
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */