/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm
INORDER TRAVERSAL
    1. We will do inorder traversal.
    2. If at any point the left subtree is greater than the root value or if the right subtree is less or equal to the root then we return false.
    3. Else return true.
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Did code run on leetcode? Yes.
    
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;
        Stack <TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null && root.val<=prev.val) return false;
            prev = root;
            root = root.right;
            
        }
        return true;
    }
}