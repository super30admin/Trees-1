// ## Problem 1

// https://leetcode.com/problems/validate-binary-search-tree/


 // Definition for a binary tree node.
  public class Problem1 {
      int val;
      Problem1 left;
      Problem1 right;
      Problem1() {}
      Problem1(int val) { this.val = val; }
      Problem1(int val, Problem1 left, Problem1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


// time: O(n) n = nodes in a tree
// space: O(h) h = height of the tree

class Solution {
    
    Problem1 prev;
    boolean flag;
    public boolean isValidBST(Problem1 root) {
        flag = true;
        inorder(root);
        return flag;
    }
    
    
    private void inorder(Problem1 root) {
        if (root == null) return;
        
        inorder(root.left);
        
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        if (flag){
            inorder(root.right);
        }
        
      
    }
}