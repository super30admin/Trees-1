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
class BinaryTreeFromPreorderInorder {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(n)
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Edge Case Checking
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        
        // The root element would always be the first element in the preorder array
        TreeNode root = new TreeNode(preorder[0]);
        int root_index = -1;
        
        // Find the root index in the inorder array
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                root_index = i;
                break;
            }
        }
        
        // Preorder Extraction
        int[] preLeft = Arrays.copyOfRange(preorder, 1, root_index+1);
        int[] preRight = Arrays.copyOfRange(preorder, root_index+1, preorder.length);
        
        // Inorder Extraction
        int[] inLeft = Arrays.copyOfRange(inorder, 0, root_index);
        int[] inRight = Arrays.copyOfRange(inorder, root_index+1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}