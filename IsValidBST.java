/**Leetcode Question - 98 - Validate Binary Search Tree */
/**Algorithm - Inorder Traversal
 * Set the prev to null initially to mark that the root rlrmrnt does not have a previous
 * Set isBST to true inititally
 * Recursive calls to the inorder traversal method passing the left or the right root
 * Check the value of the previous to the current root element - Since this is inorder traversal, the previous element always has to be smaller than the current root element
 */
/**TC- O(N) - N - number of nodes
 * SC- O(1)
 */
public class IsValidBST {
    class Solution {
        TreeNode prev;
        boolean isBST;
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            prev = null;
            isBST = true;
            inorder(root);
            return isBST;
        }
        private void inorder(TreeNode root){
            if(root == null){
                return;
            }
            inorder(root.left);
            if(prev!=null && prev.val >= root.val){
                isBST = false;
                return;
            }
            prev = root;
            inorder(root.right);
        }
    }
}

/**Iterative Solution usig stack
 * The algorith remains same
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev!= null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }