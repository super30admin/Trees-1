// Time Complexity : O(n)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* The root is the first element of the preorder array.
Find the element in inorder array and create new arrays left and right subarrays in inorder
do this recursively
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }

    public TreeNode helper(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);
        root.left = helper(preLeft, inLeft);
        root.right = helper(preRight, inRight);
        return root;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
The root is the first element of the preorder array.
Build a hashmap to retireve the index of the elements from inorder
Find the element in inorder array and call left and right subarrays in inorder based on index of the root
do this recursively
*/

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
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return helper(preorder, hm, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, map, start, rootIdx - 1);
        root.right = helper(preorder, map, rootIdx + 1, end);
        return root;
    }
}