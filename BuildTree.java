import java.util.Arrays;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//TC: O(n^2)
//SC: O(n)
class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length == 0) return null;
        //logic
        int rootVal = preorder[0];
        int rootIdx = -1; // idx is on inorder arr
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++) {//n
            if(inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx); //n
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);//n
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);//n
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);//n
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}