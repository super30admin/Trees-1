// Time Complexity : O(N) N=number of elements  in  the array. 
// Space Complexity : O(n)  extra space used for map of elements in orden tree.But if we consider 
//the stack of execution we have O(Max(depth of tree)+ n elements map  )
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// we traverse the tree recursively from left & right at same time .
// .
//Success
//Details 
//Runtime: 1 ms, faster than 97.41% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
//Memory Usage: 39.7 MB, less than 14.02% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.

private int rootIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
      Map<Integer,Integer> indexInOrderMap= new HashMap<>();
      int inI=0;
      for (int v:inorder)
          indexInOrderMap.put(v,inI++);
      return buildTree(preorder, inorder, 0, inorder.length - 1,indexInOrderMap);
    }
    

  private TreeNode buildTree(int[] preorder,  int[] inorder, int inStart, int inEnd,Map<Integer,Integer> inOrMap) {
    if (inStart > inEnd) return null;
    TreeNode root = new TreeNode(preorder[rootIndex++]);
    if (inEnd == inStart) return root;
    int i = findRootInOrder(inOrMap, root.val);
    root.left = buildTree(preorder,  inorder, inStart, i - 1,inOrMap);
    root.right = buildTree(preorder, inorder, i + 1, inEnd,inOrMap);
    return root;
  }


    private int findRootInOrder(Map<Integer,Integer> inOrMap, int rootVal) {
      return inOrMap.get(rootVal);
    }
}