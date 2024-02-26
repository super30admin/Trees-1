// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Arrays;

class BinaryTreeFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length == 0) return null;
        //logic
        int rootVal = preorder[0];
        int rootidx = -1;
        TreeNode treeNode = new TreeNode();
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootidx = i;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inright = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);
        int[] preleft = Arrays.copyOfRange(preorder, 1, inleft.length + 1);
        int[] preright = Arrays.copyOfRange(preorder, inleft.length + 1, preorder.length);

        treeNode.val = rootVal;
        treeNode.left = buildTree(preleft, inleft);
        treeNode.right = buildTree(preright, inright);

        return treeNode;
    }
}