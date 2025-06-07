// Space Complexity : O(n)
//Time Complexity : O(n)

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Inorder(root,result);
        return result;
        
    }
    private void Inorder(TreeNode root, List<Integer> result){
        //Base case
        if(root == null) return;

        // Travese through left node
        Inorder(root.left,result);
        result.add(root.val);
        //Traverse through right node.
        Inorder(root.right,result);
    }
}