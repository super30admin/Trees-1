//Time Complexity : O(n)
//Space Complexity : O(n)

 /* Definition for a binary tree node.
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



 import java.util.HashMap;

 public class ConstructBinaryTree {
     int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        index = 0;
        return helper(preorder, 0, preorder.length - 1, map);
    }

    private TreeNode helper (int[] preorder, int start, int end, HashMap<Integer, Integer> map) {

        if(start > end) return null;

        int rootVal = preorder[index];
        index++;

        int rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIndex - 1, map);
        root.right = helper(preorder, rootIndex + 1, end, map);
        return root;
    }

}
