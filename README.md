# Trees-1

## Problem 1: Validate Binary Search Tree

```Java
// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(n), to store the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> st = new Stack<>();
        TreeNode prev = null;

        while(root != null || !st.isEmpty()){
            while(root != null){ //inorder(root.left)
                st.push(root);
                root = root.left;
            }
            root = st.pop();

            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
```

## Problem 2: Binary Tree from Preorder and Inorder

```Java
// Time Complexity : O(n^2)
// Space Complexity : (n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0)
            return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx=-1;

        //finding root in order
        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == rootVal){
                idx=i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx); //idx-1
        int[] preLeft = Arrays.copyOfRange(preorder, 1, idx+1); //inLeft.length
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, idx+1, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
```