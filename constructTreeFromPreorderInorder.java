// TC O(N^2) because we are travelling to each and at each node we are copying over elements and creating new arrays splititng into left and right
// SC O(N^2) as well
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder == null || inorder == null || preorder.length == 0) {
          return null;
      }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }
}