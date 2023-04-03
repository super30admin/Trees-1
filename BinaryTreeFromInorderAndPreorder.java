/**
 * Time Complexity - O(N)
 * Space Complexity - O(N)
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || preorder.length != inorder.length)
            return null;
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int instart, int inend, int prestart) {
        //boundary conditions
        if(instart < 0 || inend >= inorder.length || instart > inend || 
                prestart < 0 || prestart >= preorder.length)
            return null;
        TreeNode node = new TreeNode(preorder[prestart]);
        int curIndex = instart;
        for(; curIndex <= inend; curIndex++)
            if(inorder[curIndex] == node.val)
                break;
        node.left = buildTree(preorder, inorder, instart, curIndex - 1, prestart + 1);
        node.right = buildTree(preorder, inorder, curIndex + 1, inend, prestart + (curIndex - instart + 1));
        return node;
    }
}
