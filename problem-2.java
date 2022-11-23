import java.util.*;

//TC is O(n)
//SC is O(n)
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recurse(preorder, inorder, 0, preorder.length - 1);

    }

    private TreeNode recurse(int[] preorder, int[] inorder, int startIdx, int endIdx) {
        // base
        if (startIdx > endIdx) {
            return null;
        }

        // logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = recurse(preorder, inorder, startIdx, rootIdx - 1);
        root.right = recurse(preorder, inorder, rootIdx + 1, endIdx);

        return root;

    }
}