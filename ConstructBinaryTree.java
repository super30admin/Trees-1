//Time Complexity: O(n)
//Space Complexity: O(n^2)
/*
 * here we get a root value from the preorder and search for that in the inorder
 * the left to it is the left subtree and right side is the right subtree. then 
 * we run the same for the left and right subtree.
 */
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
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length == 0)return null;
        //logic
        int rootVal= preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        //O(n)
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        //O(n)
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
