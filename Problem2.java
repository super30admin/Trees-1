// Time Complexity : O(n) where n = number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem2 {
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private static TreeNode buildTree(int[] preorder, int[] inorder, int preorderStartIndex, int preorderEndIndex, int inorderStartIndex, int inorderEndIndex) {
        // if preorderStartIndex > preorderEndIndex or inorderStartIndex > inorderEndIndex, return null
        if (preorderStartIndex > preorderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }
        // Since value at start index of preorder array is the value of root, create a root node with that value
        TreeNode root = new TreeNode(preorder[preorderStartIndex]);
        // Search for the root value in the inorder array to get index of root in the inorder array
        int inorderRootIndex = -1;
        for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
            if (inorder[i] == preorder[preorderStartIndex]) {
                inorderRootIndex = i;
                break;
            }
        }
        // Find root of left subtree
        TreeNode left = buildTree(preorder, inorder, preorderStartIndex+1, preorderStartIndex + inorderRootIndex - inorderStartIndex, inorderStartIndex, inorderRootIndex-1);
        // Find root of right subtree
        TreeNode right = buildTree(preorder, inorder, preorderStartIndex + inorderRootIndex - inorderStartIndex + 1, preorderEndIndex, inorderRootIndex+1, inorderEndIndex);
        // Root of left subtree is left child of main root
        root.left = left;
        // Root of right subtree is right child of main root
        root.right = right;
        // Return root
        return root;
    }

    // Function to print the binary tree
    public static List<Integer> printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
          return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(null);      
            } else {
                q.add(curr.left);
                q.add(curr.right);
                res.add(curr.val);
          }
        }
        int i = res.size()-1;
        while (res.get(i) == null) {
            res.remove(i--);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        List<Integer> ans = printTree(root);
        System.out.println(ans);
    }
}
