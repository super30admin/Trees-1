import java.util.Arrays;
import java.util.HashMap;

/*
Time Complexity -> O(N * H)
space Complecity -> O(H * H)
*/

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int rootIndex = 0;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorder_right = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] preorder_left = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] preorder_right = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

        root.left = buildTree(preorder_left, inorder_left);
        root.right = buildTree(preorder_right, inorder_right);

        return root;
    }
}

/*

Time Complexity -> O(N)
Space Complexity -> O(N)
*/

class Solution2 {
    int idx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int start, int end) {

        if (start > end) {
            return null;
        }
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = createTree(preorder, start, rootIndex - 1);
        root.right = createTree(preorder, rootIndex + 1, end);
        return root;
    }
}