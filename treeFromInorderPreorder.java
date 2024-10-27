// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        // find the root in pre
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        // find root in inorder
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIdx = i;
                break;
            }
        }
        int[] inorderL = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderR = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        int[] preL = Arrays.copyOfRange(preorder, 1, inorderL.length + 1);
        int[] preR = Arrays.copyOfRange(preorder, inorderL.length + 1, preorder.length);

        root.left = buildTree(preL, inorderL);
        root.right = buildTree(preR, inorderR);
        return root;
    }
}