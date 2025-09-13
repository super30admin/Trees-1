//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :Yes
//Approach: The idea is to use inorder for fetching the indices of the parent and the child
//Preorder is used for fetching the rootVal, once you do that, find the index of the root in the inorder array
//to the left of the root index exists the left subtree, to the right exists the right subtree
//and then the problem repeats for both the left and right subtrees
import java.util.HashMap;
import java.util.Map;

public class BinaryTreePreorderInorder {

    private Map<Integer, Integer> indices;
    private int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.indices = new HashMap<>();
        this.index = 0;

        for (int i = 0; i < inorder.length; i++) indices.put(inorder[i], i);

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;

        int rootVal = preorder[index++];
        int rootIdx = indices.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }

    public static void main(String[] args) {
        final BinaryTreePreorderInorder binaryTreePreorderInorder = new BinaryTreePreorderInorder();
        final TreeNode root = binaryTreePreorderInorder.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});

        assert root.val == 3;
        assert root.left.val == 9;
        assert root.left.left == null;
        assert root.left.right == null;
        assert root.right.right.val == 20;
        assert root.right.right.left.val == 15;
        assert root.right.right.right.val == 7;
    }
}
