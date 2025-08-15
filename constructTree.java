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
// Idea is to find the root in preorder traversal and based on it, find the left sub tree and right sub tree.
// This finding of left sub tree and right sub tree is optimised by using HashMap
// Once the node is built, we recursively build left and right sub trees.

//Time Complexity:O(n)
//Space Complexity:O(n)
class constructTree {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<inorder.length;i++)
      {
        map.put(inorder[i],i);
      }  
      this.idx = 0;
      return traversal(preorder,0,preorder.length-1,map);
    }

    private TreeNode traversal(int[] preorder, int start, int end, HashMap<Integer,Integer> map)
    {
        if(start>end) return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = traversal(preorder, start, rootIdx-1, map);
        root.right = traversal(preorder, rootIdx+1,end,map);

        return root; 
    }
}