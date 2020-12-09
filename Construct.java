/** Given preorder and inorder traversal of a tree, construct the binary tree.
* TC O(N) SC O(N)
*Code was submitted on leetcode
*/
class Solution {
    HashMap<Integer, Integer> inorderMap;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        if (inorder == null || inorder.length == 0)
            return null;
        inorderMap = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        index = 0;
        return helper(preorder, 0, inorder.length -1);
    }
    private TreeNode helper(int [] preorder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        index ++;
        int rootIndex = inorderMap.get(rootVal);
        
        
        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}
