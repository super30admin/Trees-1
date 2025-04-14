import java.util.HashMap;

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Ran on leetcode? Yes
 * Issues faced? No
 *
 * Approach:
 * 1. Use map to store inorder list with its indexes, which can later
 * be used to form left and right subtree when root is known.
 * 2. From preorder list, determine the root and create a root TreeNode.
 * 3. Recursively create left and right subtree for that root.
 * 4. The base condition is when start goes beyond end.
 * 5. This utilizes the property that for binary tree every root node
 * there would be either a null or non-null children
 */
public class ConstructBTFromPreAndInOrderTraversal {
    public static class TreeNode {
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

    int index;
    // To store the positions of inorder traversal values
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return createTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int start, int end) {
        // base
        if (start > end) {
            return null;
        }
        // logic
        int rootVal = preorder[index];
        index++;
        int rootIdxInMap = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(preorder, start, rootIdxInMap - 1);
        root.right = createTree(preorder, rootIdxInMap + 1, end);
        return root;
    }

    public static void main(String[] args) {
        ConstructBTFromPreAndInOrderTraversal obj = new ConstructBTFromPreAndInOrderTraversal();
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};

        TreeNode treeNode = obj.buildTree(preorder, inorder);
        dfs(treeNode);
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
