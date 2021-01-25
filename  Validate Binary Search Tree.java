// Time Complexity : O(n)
// Space Complexity : O(n)

// Your code here along with comments explaining your approach
// perform inorder traversal, set prev and update prev, check if cur element is <= prev then return false
// else continue with inorder traversal, this is iterative version using a stack
// push all left nodes to stack, pop node check if > prev, push all left nodes of its right child 


class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        Integer prev=null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        while(!stack.isEmpty() || node!=null){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if(prev!=null && node.val<=prev)
                return false;

            prev = node.val;    
            
            node = node.right;            
        }
        
        return true;
    }
}