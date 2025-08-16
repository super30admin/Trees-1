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

// This solutions uses recursion technique in building the tree. We divide the stack calls with start and end indices which shows the range for tree to be built. Starting from root index in pre order we divide left spaces by number of elements before the same root element in in order array. For fetching the index of element from inorder array we efficiently we use map. So for each recursion call we take the root and call twice one for building left sub tree and one for right. Whenever the ranges cross, we just terminate.
class Solution {
    // Map for tracking the indices from the in order array
    Map<Integer, Integer> map = new HashMap();
    // Index for tracking the root element. This will follow the pre order pattern i.e., for each step of recursion we follow root -> left -> right
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        if(map.size()==0) {
            for(int i=0;i<inorder.length;i++) {
                map.put(inorder[i], i);
            }
        }
        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if(start>end) return null;

        int rootVal = preorder[idx++];
        int index = map.get(rootVal);

        TreeNode node = new TreeNode(rootVal);
        node.left = helper(preorder, start, index-1);
        node.right = helper(preorder, index+1, end);
        return node;
    }

}
