// Time Complexity: O(n) where n is the length of given array.
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We will be using the recursive approach to solve this problem. We will be using a hashmap to store the inorder array elements and their corresponding indices. We will be using a helper function to construct the tree. We will be using the preorder array to construct the tree. We will be using the idx variable to keep track of the current element in the preorder array. We will be using the hashmap to get the index of the root element in the inorder array. We will be recursively calling the helper function to construct the left and right subtrees of the root node. We will be updating the idx variable to keep track of the current element in the preorder array. We will be returning the root node of the tree.
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
class ConstructTree {

    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, map, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, Map<Integer, Integer> map, int start, int end){
        if(start > end){
            return null;
        }

        int val = preorder[idx];

        TreeNode root = new TreeNode(val);
        idx++;

        int rootIdx = map.get(val);

        root.left = helper(preorder, inorder, map, start, rootIdx-1);
        root.right = helper(preorder, inorder, map, rootIdx+1, end);
        return root;
    }
}