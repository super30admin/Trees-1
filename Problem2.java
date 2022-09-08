import java.util.Arrays;

// ## Problem 2

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


 // Definition for a binary tree node.
  public class Problem2 {
      int val;
      Problem2 left;
      Problem2 right;
      Problem2() {}
      Problem2(int val) { this.val = val; }
      Problem2(int val, Problem2 left, Problem2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

// time: O(n^2)
// space: O(n^2)
class Solution {
    public Problem2 buildTree(int[] preorder, int[] inorder) {
        // null
        if (preorder.length == 0) return null;
        
        int rootVal = preorder[0];
        Problem2 root = new Problem2(rootVal);
        int idx = -1;
        // finding root in inorder
        for (int i =0; i< inorder.length; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx); // idx-1
        int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder,inLeft.length+1,preorder.length);
        
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        
        return root;
    }
}