/**

Iterative Approach:
TC - O(n) where n is the number of nodes in Binary Search Tree
Sc - O(h) where h is the height of the tree.
**/
public boolean isValidBST(TreeNode root) {
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastPopped = null;
        
        while(true)
        {
            if (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else
            {
                if (stack.isEmpty())
                {
                    break;
                }
                
                
                TreeNode pop = stack.pop();
                
                if (lastPopped != null && lastPopped.val >= pop.val)
                {
                    return false;
                }
                
                lastPopped = pop;
                current = pop.right;
            }
        }
        
        return true;
    }

/**
Recursive approach 
TC - O(n)
SC - O(h)


**/

class Solution {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        

        return isValidBSTHelper(root);
    }
    
    private boolean isValidBSTHelper(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        boolean isLeftValid = isValidBSTHelper(root.left);

        if (prev != null && prev.val >= root.val)
        {
            return false;
        }
            
        prev = root;
            
        boolean isRightValid =  isValidBSTHelper(root.right);

        return isLeftValid && isRightValid;
    }
    
}
