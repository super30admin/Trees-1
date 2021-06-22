package Trees1;

import java.util.HashMap;

/*  Time complexity : o(n)
    space complexity: o(n) 
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class ConstructBTInorderPreOrderRecursion {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0)
            return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {

        if (start > end)
            return null;

        int rootIdx = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);

        idx++;

        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);

        return root;
    }

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

}