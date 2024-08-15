//Problem 105. Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base
        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        //find root in inorder
        int rootIdx = -1;
        // O(n)
        for(int i=0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        // copyOfrange takes extra index towards end
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1+inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1+inLeft.length, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
