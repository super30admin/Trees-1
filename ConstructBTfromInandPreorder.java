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

/*
    Leetcode problem 105: Construct-binary-tree-from-preorder-and-inorder-traversal
    T.C: O(n) :: S.C: O(n)

    Solved using a Recursive approach by optimizing few instructions in the logic. Used
    a HashMap to store the index at which the elements are located - inorder array and 
    pointers to partition the inorder array (startIndex and EndIndex). Each set of pointers
    from the root is divided into left and right recursive calls. So first start is 0 and
    end is rootVal's index - 1, then (for the right recursive call) start is rootVal's index + 1
    and end is length of inorder array - 1. Base case is to return null if start > end.
*/

class Solution {
    HashMap<Integer, Integer> indexMap;
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) return null;

        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length - 1);         
    }

    private TreeNode helper(int[] preorder, int[] inorder, int startIndex, int endIndex) {
        //Base case
        if (startIndex > endIndex) return null;

        //Logic
        int rootVal = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(rootVal);

        //left partition is from startIndex - (rootVal index - 1)
        root.left = helper(preorder, inorder, startIndex, indexMap.get(rootVal) - 1);
        //right partition is from (rootVal index + 1) - endIndex
        root.right = helper(preorder, inorder, indexMap.get(rootVal) + 1, endIndex);

        //return the root after assigning left and right from bottom-up
        return root;
    }
}