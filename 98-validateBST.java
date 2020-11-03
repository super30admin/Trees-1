/**LC-98
 * ITERATIVE SOLUTION
 * Time Complexity : O(N) N-> Number of nodes
 * Space Complexity : O(H) H: height of the tree
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. We keep traversing through the left nodes and pushing them on stack till we get null.
 2. Once we get the null, we pop from the stack and put them in result.
 3. The prev pointer is pointing to the prev element in the resultant.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        
        return true;
        
    }
}