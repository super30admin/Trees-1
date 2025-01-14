import java.util.HashMap;
import java.util.Map;

//LC 105
/**
 * Dry Run by constructing a tree and writing its inorder and preorder.
 * <p>
 * Now, using the preorder and inorder, try to construct the tree.
 * <p>
 * Preorder == RootLR
 * so, each index is a Root and the right content == LR of this Root
 * <p>
 * Inorder == LRootR
 * If we find the index of the preorder.root.val in inorder, say it rootIndex.
 * Then, left of rootIndex == Left subtree of Root, and
 * right of rootIndex == Right subtree of Root
 * <p>
 * Make sure to stay within bounds of the new subtree in the inorder list.
 * <p>
 * We can start with 0 to n-1.
 * Current Node = start, end
 * Left subtree = (start, rootIndex-1)
 * Right subtree = (rootIndex+1, end)
 * <p>
 * NOTE: We know O(1) search can easily be achieved by hashing.
 * So, hash the inorder values to its index.
 * <p>
 * If values are distinct, this approach won't work and we have to follow the linear search within [start, end].
 */
public class ConstructBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * TC: O(n) + O(n) for searching
     * SC: O(h), h == n for skewed trees
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, new int[]{0});
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, int[] index) {
        int n = preorder.length;
        // NOTE: start is always increasing
        // NOTE: end is always decreasing
        if (index[0] >= n || start > end) {
            index[0]--;
            return null;
        }
        int val = preorder[index[0]];
        TreeNode root = new TreeNode(val);
        // if values are not distinct
        int rootIndex = findRootInOrder(inorder, val, start, end);
        index[0]++;
        root.left = buildTree(preorder, inorder, start, rootIndex - 1, index);
        index[0]++;
        root.right = buildTree(preorder, inorder, rootIndex + 1, end, index);
        return root;
    }

    int findRootInOrder(int[] inorder, int val, int start, int end) {
        while (start <= end && inorder[start] != val) {
            start++;
        }
        return start;
    }

    /**
     * TC: O(n)
     * SC: O(h) + O(n) for hashmap, h == n for skewed trees
     */
    public TreeNode buildTree_optimised(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valIndexMap = hashValues(inorder);
        return buildTree(preorder, valIndexMap, 0, preorder.length - 1, new int[]{0});
    }

    Map<Integer, Integer> hashValues(int[] inorder) {
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valIndexMap.put(inorder[i], i);
        }
        return valIndexMap;
    }

    TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorder, int start, int end, int[] index) {
        int n = preorder.length;
        if (index[0] >= n || start > end) {
            index[0]--;
            return null;
        }
        int val = preorder[index[0]];
        TreeNode root = new TreeNode(val);
        // if values are unique
        int rootIndex = inorder.get(val);
        index[0]++;
        root.left = buildTree(preorder, inorder, start, rootIndex - 1, index);
        index[0]++;
        root.right = buildTree(preorder, inorder, rootIndex + 1, end, index);
        return root;
    }

}
