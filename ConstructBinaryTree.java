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
class ConstructBinaryTree {
    int preoIndex;
    Map<Integer, Integer> inoIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preoIndex = 0;
        inoIndexMap = new HashMap<>();
        
        for( int i = 0; i < inorder.length; i++ ) {
        //running over all inorder element
            inoIndexMap.put(inorder[i], i); //mapping them to their indices
        }
        
        return helper(preorder, 0, preorder.length - 1);
        
    }
    
    
    private TreeNode helper( int[] preorder, int left, int right ) {
        
        if( left > right ) return null;
        
        int rootVal = preorder[preoIndex++]; //choosing preorder element
        TreeNode root = new TreeNode(rootVal); //putting inside tree as root
        
        //recursively calling helper
        root.left = helper(preorder, left, inoIndexMap.get(rootVal) - 1);
        //passing left and value from map just before root (left side of root)
        root.right = helper(preorder, inoIndexMap.get(rootVal) + 1, right);
        //passing value from map just after root and right (right side of root)
        
        return root;
    }
}