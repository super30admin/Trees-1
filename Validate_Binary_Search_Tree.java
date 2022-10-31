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
// TC : O(number of nodes)
// SC : O(height of tree)
// Method - 1
class Solution {
    TreeNode main_node_before_right;
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;
        
        if(isValidBST(root.left) == false)
            return false;
        
        if(main_node_before_right != null && main_node_before_right.val >= root.val)
            return false;
        
        main_node_before_right = root;
        
        return isValidBST(root.right);

    }
}

// Method - 2
// TC : O(number of nodes)
// SC : O(height of tree)
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;
            root = root.right;
        }
    return true;
    }
}


// Method - 3

// TC : O(number of nodes)
// SC : O(height of tree)

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return check(root, null, null);
    }
    
    private boolean check(TreeNode root, Integer max, Integer min) {
        
        // base
        if(root == null) return true;
        // logic
        if(max != null && root.val >= max)
            return false;
        if(min != null && root.val <= min)
            return false;
        boolean c1 = check(root.left, root.val, min);
        boolean c2 = check(root.right, max, root.val);
        
        return c1&&c2;
    }
}
