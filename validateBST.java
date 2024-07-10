/*
Approach 1 is use DFS and check if elements are in sorted order TC --> O(n) Sc --> O(n)
Appraoch 2 TP --> O(n)
SC --> O(1)


 */
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
import java.util.*;

class Solution {

    ArrayList<Integer> ls = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        // Approach 1 go from left root right and check if its sorted
        // Approach 2 is perform dfs without any extra space
        if (root.left == null && root.right == null) {
            return true;
        }
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);

    }

    public boolean dfs(TreeNode root, long high, long low) {
        if (root != null) {
            if (root.val >= high || root.val <= low) {
                return false;
            }
            boolean left = dfs(root.left, root.val, low);
            boolean right = dfs(root.right, high, root.val);
            return left && right;
        }
        return true;

    }//method
}
