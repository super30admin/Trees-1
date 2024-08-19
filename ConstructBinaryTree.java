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
// Approach -
// preorder  = node, left, right
// inorder  = left, node, right
// fill the stack accordingly
// Time complexity = O(n).
// Space complexity = O(n)
class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case.
        if(preorder.length==0) return null;
        // logic
        // preorder = node, left, right.
        // inorder = left, node, right.
        // root is always the first element of the preorder.
        TreeNode root = new TreeNode(preorder[0]);
        // get the index in the inorder array.
        int inorderIdx=-1;
        for(int i=0;i< inorder.length;i++) {
            if(root.val == inorder[i]) {
                inorderIdx = i;    
                break;
            }
        }
        // get the left and right subtree.
        // it is always (array, start, end+1) for an array[start... end]
        int[] inLeft = Arrays.copyOfRange(inorder, 0,inorderIdx);// length = inOrderIdx+1
        int[] inRight = Arrays.copyOfRange(inorder, inorderIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1,inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);
            
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}