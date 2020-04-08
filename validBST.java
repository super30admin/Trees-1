//98.
class Solution {
    //approach - iterative inorder
    //inorder traversal must be in increasing order
    //time - O(n) - visit all nodes
    //space - O(h) - height of tree
    public boolean isValidBST(TreeNode root) {
        //edge
        if(root == null)
        {
            return true;
        }
        Stack<TreeNode> support = new Stack<>();
        TreeNode prev = null;
        while(root != null || !support.isEmpty())
        {
            while(root != null)
            {
                support.push(root);
                root = root.left;
            }
            TreeNode top = support.pop();
            //process top
            if(prev != null && prev.val >= top.val)
            {
                return false;
            }
            prev = top;
            root = top.right;
        }
        return true;
    }
}
