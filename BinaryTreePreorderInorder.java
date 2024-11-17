/*
Time complexity : O(N).

    Building the hashmap takes O(N) time, as there are N nodes to add, and adding items to a hashmap has a cost
    of O(1), so we get N⋅O(1)=O(N).

    Building the tree also takes O(N) time. The recursive helper method has a cost of O(1) for each call
    (it has no loops), and it is called once for each of the N nodes, giving a total of O(N).

    Taking both into consideration, the time complexity is O(N) + O(N) = O(2N) = O(N).

Space complexity : O(N).

    Building the hashmap and storing the entire tree each requires O(N) memory. The size of the implicit system
    stack used by recursion calls depends on the height of the tree, which is O(N) in the worst case and O(logN)
    on average. Taking both into consideration, the space complexity is O(N).
 */

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreePreorderInorder {

    int preorderIndex;
    HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderIndexMap = new HashMap<>();

        //As we need to fetch the root index from inorder always, we can use hashmap to store the index
        for(int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeUsingArray(preorder, 0, preorder.length-1);
    }

    private TreeNode buildTreeUsingArray(int[] preorder, int left, int right)
    {
        if(left > right) return null;

        //preorder will give us the root and we can create a root node
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

        //after finding the root we can get the left and right subtree from inorder

        root.left = buildTreeUsingArray(preorder,
                left,
                inorderIndexMap.get(rootValue) - 1); //element on left side of the root will be the right index for left traversal in preorder

        root.right = buildTreeUsingArray(preorder,
                inorderIndexMap.get(rootValue) + 1, //element on right side of the root will be the left index for right traversal in preorder
                right);

        return root;
    }
}
