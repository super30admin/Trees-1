// Time Complexity : O(N) N=number of elements  in  the TREE. 
// Space Complexity : O(1) no extra space used.But if we consider the stack of execution we have O(Max(depth of tree))
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// we traverse the tree recursively from left & right at same time .
// .
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
//Memory Usage: 39.7 MB, less than 77.68% of Java online submissions for Validate Binary Search Tree.

 public boolean isValidBST(TreeNode root){
      return isValidBST(root,null,null);
  }

private boolean isValidBST(TreeNode node,Integer minValue,Integer maxValue){
        if (node==null)
            return true;
        if (minValue!=null && node.val<=minValue  || maxValue!=null && node.val>=maxValue ){
            return false;
        }

        return isValidBST(node.left,minValue,node.val) && isValidBST(node.right,node.val,maxValue);
    }
