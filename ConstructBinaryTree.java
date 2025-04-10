// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * The problem is about reconstructing a binary tree from its preorder and inorder traversal arrays.  
 * I used a recursive approach that picks the current root from the preorder array and finds its index in the inorder array to split the tree into left and right subtrees.  
 * A hashmap is used to store the indices of elements in the inorder array for O(1) lookup, which helps efficiently build the tree.
 */  
class Solution {
    private int preIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Populate the hashmap with inorder values and their indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this node in the inorder traversal
        int inIndex = inorderMap.get(rootVal);

        // Recursively construct the left and right subtrees
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }
}
