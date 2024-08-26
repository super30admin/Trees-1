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
class ContructTreeFromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for(int i=0;i<inorder.length;i++) {
            if(rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        int[] inOrderLeft = Arrays.copyOfRange(inorder,0,rootIndex);
        int[] inOrderRight = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
        int[] preOrderLeft = Arrays.copyOfRange(preorder,1,inOrderLeft.length+1);
        int[] preOrderRight = Arrays.copyOfRange(preorder,inOrderLeft.length+1,preorder.length);
        root.left = buildTree(preOrderLeft,inOrderLeft);
        root.right = buildTree(preOrderRight,inOrderRight);
        return root;
    }
}