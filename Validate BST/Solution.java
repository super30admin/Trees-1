// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    
     Stack stack = new Stack();
     public void inOrder(TreeNode root) {
            if(root != null) {
               inOrder(root.left);
        stack.push(root.val);
            inOrder(root.right); 
            }
     }
    public boolean isValidBST(TreeNode root) {
            if(root == null) {
                return true;
            }
            
            inOrder(root);
            int i = (int)stack.pop();
            
            while(!stack.isEmpty()) {
                int j = (int)stack.pop();
                if (i<=j) {
                    return false;
                }
                i=j;
                
            }
            return true;
        }
    }
