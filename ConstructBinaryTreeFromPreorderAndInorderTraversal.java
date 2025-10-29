// Time Complexity : O(n) where n is the number of nodes, as we have to traverse all nodes once.
// Space Complexity : O(n) as we have to store all nodes and their indices on the hashmap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
* Problem: Construct Binary Tree From Preorder and Inorder Traversal
* */

/*
* Approach: Using HashMap and Recursion
* In this approach, we construct a binary tree from preorder and inorder traversal arrays. We use the preorder to
* first locate the root and then construct the left and right subtrees for this root. This is done recursively by
* getting the index of the root in inorder array so that we know which two halves to recurse upon. If the inorder
* array was not provided we would have got various shapes of binary trees for a single array. Since, we have these
* two traversal given to us, it helps us to construct the right BT.
* */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        this.idx = 0;
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        // base
        if (start > end) return null;

        // logic
        int rootValue = preorder[idx++];
        int rootIdx = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }

    // Driver code
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode treeNodeResult = constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder);
        System.out.println(treeNodeResult.val);
    }
}
