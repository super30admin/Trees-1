import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
 * Pre order: root-left-right
 * In order : left-root-right
 * 
 * For a element at i (limit 0->n-1) the left subtree in inorder array is start,
 * j-1 & right subtree is j+1, n-1; where j is the index where
 * preOrder[i]==inOrder[j]
 * 
 * Things to note:
 * each recursive we go one index right in preorder
 * At each value in preorder get the index in inorder and determine the left and
 * right sub-tree and continue the same recursively.
 * 
 * 
 * 
 */

public class ConstructBinaryTreeRecursive {
    Map<Integer, Integer> cache;
    int indx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        cache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);

    }

    private TreeNode helper(int[] preOrder, int start, int end) {
        // base case
        if (start > end)
            return null;

        // logic
        int rootVal = preOrder[indx];
        int iRValIndx = cache.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preOrder, start, iRValIndx - 1);
        root.right = helper(preOrder, iRValIndx + 1, end);

        return root;

    }
}
