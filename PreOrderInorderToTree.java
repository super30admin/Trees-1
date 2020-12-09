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
class PreOrderInorderToTree {
     Map<Integer, Integer> map = new HashMap<>();
     int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder == null || preorder.length == 0) {
           return null;
       }
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0 , preorder.length - 1);
        
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end)
            return null;
        int rootVal =  preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}