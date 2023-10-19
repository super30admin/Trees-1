package S30.exercises;

import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

// Approach:  Preorder traversal of binary tree is Root, left, right and Inorder traversal is left, root, right.
//preorder first element is root and then seek the root element inorder by searching the map which  contains element and
// its position. Construct the binary tree by calling recursively buildTree method to  construct both left and right trees
public class ConstructBinaryTreeUsingPreOrderInorderArrays {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null; // we do not know where the root starts
        //create the hashMap to contain inorder element value as key and element index as value

        Map<Integer, Integer> map = new HashMap<>();
        int inorderLength = inorder.length;
        for(int i = 0; i < inorderLength; i++){
            map.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, inorder.length - 1, 0, map);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, int start, int end,
                               int preorderIndex,  Map<Integer,Integer> map) {
        if (start > end) return null;
        // preorder traversal is root, left, right hence, preorder array's 0th element contains root
        // hence create the root
        int rootVal = preorder[preorderIndex];
        TreeNode node = new TreeNode(rootVal);
        int inorderIndex = map.get(rootVal);
        int leftTreeSize = inorderIndex - start;
        node.left = constructTree(preorder, inorder, start, inorderIndex-1, preorderIndex+1,map);
        node.right = constructTree(preorder, inorder,inorderIndex + 1,end, preorderIndex +
                leftTreeSize+1, map);
        return node;
    }
         class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode() {}
           TreeNode(int val) { this.val = val; }
           TreeNode(int val, TreeNode left, TreeNode right) {
               this.val = val;
               this.left = left;
               this.right = right;
           }
       }
      
}
