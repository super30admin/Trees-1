// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//as preOrder follows root->left->right insert all inorder elements in map. and iterate over preorder as one element as root
//and find the index position in map and pass the left tree boundries values and right tree boundries recusrsivly.  

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Problem2 {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        idx = 0;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1, 0);
    }

    private TreeNode helper(int[] preorder, int start, int end, int ridx) {
        if (start > end) return null;

        int rootValue = preorder[idx];
        idx++;

        ridx = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        root.left = helper(preorder, start, ridx - 1, ridx);
        root.right = helper(preorder, ridx + 1, end, ridx);

        return root;
    }

    private void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Problem2 treeBuilder = new Problem2();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = treeBuilder.buildTree(preorder, inorder);

        treeBuilder.printInorder(root);
    }
}
