//Leetcode: https://leetcode.com/submissions/detail/633051581/
//Time: O(N) as we are traversing all nodes onces.
//Space: O(height of tree), In worst case that can be O(n) when the tree is skewed.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || stack.Count > 0) {
            
            while(root != null) {
                stack.Push(root);
                root = root.left;
            }
            
            root = stack.Pop();
            if(prev != null) {
                if(prev.val >= root.val) {
                    return false;
                }
            }
            prev = root;
            root = root.right;
        }
        return true;        
    }
}