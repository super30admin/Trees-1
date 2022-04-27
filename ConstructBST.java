// TC: O(n) we're going to every node
// SC: O(n) map contains all nodes, all nodes are unique
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBST {
        int preIdx;
        Map<Integer, Integer> map; // has value -> index for inorder array
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preIdx = 0;
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return arrayToTree(preorder, 0, preorder.length - 1);
        }

        private TreeNode arrayToTree(int[] preorder, int left, int right) {
            if (left > right) return null;

            int rootValue = preorder[preIdx++];
            TreeNode root = new TreeNode(rootValue);

            root.left = arrayToTree(preorder, left, map.get(rootValue) - 1);
            root.right = arrayToTree(preorder, map.get(rootValue) + 1, right);
            return root;
        }
}
