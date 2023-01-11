// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Question2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        {
            return null;
        }
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int rootIdx = -1;
        for(int i=0; i<inorder.length; i++)
        {
            if(inorder[i] == rootval)
            {
               rootIdx = i;
                break; 
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1+inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1+inLeft.length, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}