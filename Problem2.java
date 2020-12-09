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
/** For the below iterative approach:
    Time and space complexity are both O(N^2)
*/
/**class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0)
            return null;
            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);
            int idx = -1;
            for(int i = 0;i < inorder.length; i++){
                if(rootVal == inorder[i]){
                    idx = i;
                    break;
                }
            }
            int[] preleft = Arrays.copyOfRange(preorder, 1, idx + 1);
            int[] preright = Arrays.copyOfRange(preorder, idx + 1, preorder.length);
            int[] inleft = Arrays.copyOfRange(inorder, 0, idx);
            int[] inright = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
            root.left = buildTree(preleft, inleft);
            root.right = buildTree(preright, inright);
            return root;
        }
      
    }
*/


/**
 * Problem 105
 * For the below recursive approach:
 * Time and Space complexity are O(N).
*/
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end)
            return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}