/* RECURSIVE Solution */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        inorder_helper(result,root);
        return result;
    }
    
    public void inorder_helper(List<Integer> result, TreeNode root)
    {
        if(root==null)
            return;
        
        inorder_helper(result,root.left);
        result.add(root.val);
        inorder_helper(result,root.right);
    }
}