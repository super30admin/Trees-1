// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;

        int rootVal = preorder[0];

        int rootIdx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
