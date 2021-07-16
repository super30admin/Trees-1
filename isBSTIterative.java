//Iterative approach to check if the given tree is BST or not

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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        //creating a prev variable to check if its BST or not
        TreeNode prev = null;
        
        //iterative approach of Inorder Traversal
        while(root != null || !stack.isEmpty()){
            //left
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            //root
            root = stack.pop();
            //System.out.println(root.val);
            
            //validating BST
            if(prev != null && prev.val >= root.val)
                return false;
            
            //updating prev val to next val
            prev = root;
            
            //right
            root = root.right;
            
            
        }
        //System.out.println(root.val);
        return true;
    }
}
