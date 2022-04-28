import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    //recursion solution
    //Definition for a binary tree node.
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
//    TC : O(n^2)
//    Sc : O(n^2) where h = height of tree

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0
                    || inorder.length == 0) return null;

            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);
            int rootIdx = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal) {
                    rootIdx = i;
                    break;
                }
            }
            int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
            int[] inOrderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
            int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
            int[] preOrderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);

            root.left = buildTree(preOrderLeft, inOrderLeft);
            root.right = buildTree(preOrderRight, inOrderRight);
            return root;
        }
    }

    class Solution2 {
        //    TC : O(n)
        //    Sc : O(n)

        Map<Integer, Integer> map;
        int idx;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0
                    || inorder.length == 0) return null;

            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int start, int end) {
            //base case
            if (start > end) return null;

            //logic
            int rootVal = preorder[idx];
            TreeNode root = new TreeNode(rootVal);
            idx++;
            int rootIdx = map.get(rootVal);

            root.left = helper(preorder, start, rootIdx - 1);
            root.right = helper(preorder, rootIdx + 1, end);
            return root;
        }
    }
}
