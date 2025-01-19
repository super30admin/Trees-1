/* TC: O (n) where n is the number of nodes in the resulting tree
 * SC: O (n)
 *
 * Approach: Store the indices of the inorder array in a map
 * Iterate over the preorder traversal, and for each node, create a root,
 * and build it's left subtree by taking the root from the next preorder index,
 * and the tree from the range left, inorderIndex - 1;
 * and the right subtree by taking the root as the next preorder index and the
 * tree from the range inorderIndex + 1, right
 */
import java.util.HashMap;
import java.util.Map;

public class ConstructBST1 {

    // Definition for a binary tree node.
    public class TreeNode {
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
     
    class Solution {

        // global preorder array
        int[] preorder;

        // helps determine where each individual subtree lies
        Map<Integer, Integer> inorderMap = new HashMap<>();

        // keeps track of which root to process next
        int preorderIndex = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            int i = 0;

            // create a map of each value and its 'index'
            // in the inorder representation
            for(int val: inorder) {
                inorderMap.put(val, i++);
            }
            //the entire tree lies between 0, l - 1
            return buildTree(0, inorder.length - 1);
        }
        TreeNode buildTree(int left, int right) {

            if (left > right) {
                return null;
            }

            // the next value in preorder is always the next root
            int rootVal = preorder[preorderIndex++];
            // look up the next root in the inorderMap
            TreeNode root = new TreeNode(rootVal);

            // the root's left subtree is in the indices between
            // left, i - 1; and the left subtree root is the next 
            // preorderIndex
            root.left = buildTree(left, inorderMap.get(rootVal) - 1);

            // the root's right subtree is in the indices between
            // i + 1, right; and the right subtree root is the next-to-next
            // preorderIndex
            root.right = buildTree(inorderMap.get(rootVal) + 1, right);

            return root;
        }

    }
}
