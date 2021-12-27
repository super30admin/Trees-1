// Time Complexity: O(n)
// Space Complexity: O(h) h is height of tree

// DFS
public class ValidateBST {

    TreeNode prev = null;
    boolean isValid = true; // assume it is true
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return isValid;
        inOrderDfs(root);
        return isValid;
    }
    
    private void inOrderDfs(TreeNode root)
    {
        if(root == null)
            return;
        inOrderDfs(root.left);
        if(prev != null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        // update prev before going to next node
        prev = root;
        inOrderDfs(root.right);
    }
}

// Controlled DFS
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        // inorder traversal gives sorted list
        TreeNode prev = null;
        
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty())
        {
            // go to the last root node on left
            while(root != null)
            {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            // check if sorted order is breached
            if(prev != null && prev.val >= root.val)
                return false;
            // correct order of inorder, update prev
            prev = root;
            // go to the right side
            root = root.right;
        }
        return true;
    }
}
