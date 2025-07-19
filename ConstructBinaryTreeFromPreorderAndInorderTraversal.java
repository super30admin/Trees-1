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
    int index;
    Map<Integer, Integer> inorderMap;

    // Have a continuous index for preorder and find that value in inorder. 
    // All values before this index goes to LST and after belongs to RST.
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 || inorder == null 
            || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    
    private TreeNode dfs(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inorderMap.get(rootVal);
        
        root.left = dfs(preorder, start, rootIdx - 1);
        root.right = dfs(preorder, rootIdx + 1, end);

        return root;

    }
}