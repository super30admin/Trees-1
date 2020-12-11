// Time - O(N)
// Space - O(N)
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null;
        
        while(root!=null || !s.isEmpty()) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && (prev.val >= root.val || prev.val >= root.val)) {
                return false;
            }
            prev = root;
            
            root = root.right;
            
        }
        return true;
    }
}

// recursive
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }
        
        if(min != null && min.val >= root.val) {
            return false;
        }
        
        if(max != null && max.val <= root.val) {
            return false;
        }
        
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}

