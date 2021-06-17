//Time and Space complexity : O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        while(!stack.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            root=stack.pop(); //inorder traversal
            if(prev!=null && prev.val>=root.val) return false; //main condition 
            //to check for BST
            prev=root;
            root=root.right;
        }
        return true;
    }
}
