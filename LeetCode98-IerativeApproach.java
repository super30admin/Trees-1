//iterative approach
//Touching each node - TC- O(n) ; n = number of nodes
//SC- O(h) -- height of the tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
     
        
        Stack<TreeNode> s = new Stack<>();
        while(root!= null || !s.isEmpty())
        {
            while(root!=null)
            {
            //go left and push to the stack
            s.push(root);
            root = root.left;
            }
            //we reached to the null point
            //pop from the stack
            //print
            //and check for the right node
            root = s.pop();
            //come here after visitng root's left
            //root
            //System.out.println(root.val);
            
            if(prev!= null && prev.val >= root.val)
                return false;
            
            prev = root;
            //root's right
            root = root.right;
        }
        
        return true;
    }
}