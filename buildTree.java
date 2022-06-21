
// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

import java.util.Arrays;
import java.util.HashMap;

class TreeNode {
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

class Main {

    // approch 1
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {

        // base case
        if (preorder.length == 0)
            return null;
        // root of the tree will be on first index of the inorder
        int rootVal = preorder[0];
        // initliaze tree with rootVal as root node
        TreeNode root = new TreeNode(rootVal);
        // to find index of rootVal in inorder array
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        // when we find rootIndex in the inorder array left side of this index is left
        // subtree and right side will be right sub tree. we are doing this until we
        // find on each side there is only single element so we can build our tree.

        // inorder left subtree
        int[] il = Arrays.copyOfRange(inorder, 0, rootIdx);
        // inorder right subtree
        int[] ir = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        // preorder left subtree
        int[] pl = Arrays.copyOfRange(preorder, 1, il.length + 1);
        // preorder right subtree
        int[] pr = Arrays.copyOfRange(preorder, il.length + 1, preorder.length);

        // recursion
        root.left = buildTree1(pl, il);
        root.right = buildTree1(pr, ir);
        return root;
    }

    // global declaration of HashMap ;
    private static HashMap<Integer, Integer> map;

    // index for traversing through preorder;
    private static int idx;

    // approch 2
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        idx = 0;

        // put inorder values and it index in the map.
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    // helper function
    private static TreeNode helper(int[] preorder, int left, int right) {

        // if left > right that means left pointer and right pointer crossed each other
        // that means there is no further nodes so we return null
        if (left > right)
            return null;
        // rootVal from the preorder
        int rootVal = preorder[idx++];
        // creating root node at each recursion
        TreeNode root = new TreeNode(rootVal);
        // recursion

        // here first we find index of the root value in inorder array then divide it
        // using pointer to recurse.
        root.left = helper(preorder, left, map.get(rootVal) - 1);
        root.right = helper(preorder, map.get(rootVal) + 1, right);
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        TreeNode result = buildTree1(preorder, inorder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }
}