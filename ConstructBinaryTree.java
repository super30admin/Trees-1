// Time Complexity :O(N) where N is number of nodes
// Space Complexity : O(N) for the values in hashMap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// From the preorder, we can get the root value and from the inorder we can get left values or the root right values.
// Once we get the root index from inorder map, we can get start and end pointer for left tree and start and end pointer of right
// tree from inorder. We can keep finding left node from the left tree and right node from the right tree.

import java.util.HashMap;

public class ConstructBinaryTree {
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return getBinaryTree(preorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode getBinaryTree(int[] preorder, HashMap<Integer, Integer> inorderMap, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) return null;

        TreeNode root = new TreeNode(preorder[index++]);
        int rootIndex = inorderMap.get(root.val);

        root.left = getBinaryTree(preorder, inorderMap, inorderStart, rootIndex - 1);
        root.right = getBinaryTree(preorder, inorderMap, rootIndex + 1, inorderEnd);
        return root;
    }
}
