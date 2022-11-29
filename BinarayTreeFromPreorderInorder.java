import java.util.HashMap;
/**
 * TC - O(n) where n is total number of nodes
 * SC - O(n) where n is total number of nodes
 */
public class BinarayTreeFromPreorderInorder {
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {

        HashMap<Integer, Integer> inorderMap;
        int preOrderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderMap = new HashMap();

            for(int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return buildTree(preorder, inorder, 0, inorder.length -1);

        }

        public TreeNode buildTree(int[] preorder,int[] inorder, int start, int end) {
            if (start > end ) {
                return null;
            }

            int rootVal = preorder[preOrderIndex];
            preOrderIndex++;

            TreeNode root = new TreeNode(rootVal);

            int rootIndex = inorderMap.get(rootVal);

            root.left = buildTree(preorder, inorder, start, rootIndex -1);
            root.right = buildTree(preorder, inorder, rootIndex + 1, end);

            return root;
        }
    }
}
