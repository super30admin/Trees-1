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

TC:O(N)
SC:O(1)
class Solution {
    TreeNode prev= null;
    boolean isvalid=true;
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return false;
        } 
        if (root.left == null && root.right == null){
            return true;
        }
        inorder(root, null, null);
        return isvalid;
        
    }

    private void inorder(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return;
        }
        inorder(root.left, min, root.val );
        inorder(root.right, root.val, max);
        if (min != null && min >= root.val || max!= null  && root.val >= max) {
            isvalid = false;
            return;
        }
        
    }
}


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
    int idx =0;
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++) {
            m.put(inorder[i], i);
        }
        TreeNode result = createTree(preorder, 0, preorder.length-1);
        return result;
   
    }
    private TreeNode createTree(int[] preorder, int start, int end) {

        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        int rootindex = m.get(root.val);
        root.left = createTree(preorder, start, rootindex-1);
        root.right = createTree(preorder, rootindex+1, end);
        return root;
    }
}
