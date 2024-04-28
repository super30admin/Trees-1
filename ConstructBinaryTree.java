// Time Complexity : O(N) - no. of nodes in the tree
// Space Complexity : O(H) - h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
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
class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length ==0){
            return null;
        }

        int rootVal = preorder[0];

        int index=-1;
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == rootVal) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1,preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}

/**
 * T = O(N) S= O(N)
 * USing hashmap
 */
class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        index = 0;

        for(int i=0;i< inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start,int end) {
        // base case
        if(start > end) {
            return null;
        }

        //logic
        int rootVal = preorder[index];
        index++;

        TreeNode root = new TreeNode(rootVal);
        int rtIdx = map.get(rootVal);

        root.left = helper(preorder, start, rtIdx -1);
        root.right = helper(preorder, rtIdx+1, end);

        return root;

    }
}