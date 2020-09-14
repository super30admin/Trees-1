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

// Iterative
class ValidateBST {
    
    //  Time Complexity:    O(n) - number of nodes
    //  Space Complexity:   O(h) - height of the root/ Depth of the deepest node
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(prev != null && prev.val >= root.val){
                return false;
            }
            
            prev = root;
            root = root.right;
        }
        
        return true;
    }
}

// Recursive 
    // -- Passing LowerLimit(min) and HigherLimit(max) with each recursion
    // -- Verifying if the node is within those limits

    //  Time Complexity:    O(n) - number of nodes
    //  Space Complexity:   O(1) - No nodes are saved

// class ValidateBST {
//     public boolean isValidBST(TreeNode root) {
//         return isValidBST(root, null, null);
//     }
    
//     public boolean isValidBST(TreeNode root, Integer min, Integer max){
//         if(root == null)
//             return true;
//         int val = root.val;
//         if( max != null && val >= max)
//             return false;
//         if(min != null && val <= min)
//             return false;
//         return isValidBST(root.left,min,val) && isValidBST(root.right, val, max);
//     }
// }