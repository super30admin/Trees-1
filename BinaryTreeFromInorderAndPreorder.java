// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Store the inorder values in hashMap
//To find the root we will traverse the preorder
//We will get the range of left subtree and right subtree from the inorder hashMap
//We will call the function recursively to build the complete tree.
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
class Solution {
    int preIndex;
    Map<Integer, Integer> inorIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inorIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorIndexMap.put(inorder[i], i);
        }
        return compute(preorder, 0, preorder.length -1);
    }
    private TreeNode compute(int[] preorder, int l, int r){
        if(l > r)
            return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = compute(preorder, l, inorIndexMap.get(rootVal) - 1);
        root.right = compute(preorder, inorIndexMap.get(rootVal)+1, r);
        return root;
    }
}