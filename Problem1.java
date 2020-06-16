// Time Complexity : O(n) where n = number of nodes in the tree
// Space Complexity : O(h) where h = height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach: We go one level down for left and right side of the tree, then the 
// max and min allowed values range changes if current node crosses or touches this limit, then BST isnt valid


class SolutionRecursive {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }
    
    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if(root==null) return true;
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
    }
}

// Approach: Keep track of prev element that was popped from stack. 
// If that element is greater than cuurent node, then it isn't valid BST because while
// popping the elements in inorder, we always have elements in sorted order if it is a BST

class SolutionIterative {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !st.isEmpty()) {
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val) return false;
            prev=root;
            root=root.right;
        }
        return true;
    }
}