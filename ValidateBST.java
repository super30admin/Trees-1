//Time Complexity: O(n)
//Space Complexity: O(n)

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
    public boolean isValidBST(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        helper(traversal, root);

        for(int i=1;i<traversal.size();i++){
            if(traversal.get(i)<=traversal.get(i-1))
                return false;
        }
        return true;
    }

    public static void helper(List<Integer> traversal, TreeNode root){
        if(root==null)
            return;
        helper(traversal, root.left);
        traversal.add(root.val);
        helper(traversal, root.right);
    }
}