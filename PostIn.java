Time Complexity-O(n)
Space Complexity-O(1)

class Solution {
public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, inorder.length - 1, 0);
    }
    
    private TreeNode buildTree(int[] preorder, int index, int[] inorder, int end, int start) {
        if (index >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int i;
        for (i = end; i >= start; i--) {
            if (preorder[index] == inorder[i]) {
                break;
            }
        }
        root.left = buildTree(preorder, index + 1, inorder, i - 1, start);
        root.right = buildTree(preorder, index + i - start + 1, inorder, end, i+1);
        return root;
    }
}
