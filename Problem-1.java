// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            while(root!= null) {
                s.push(root);
                root = root.left;
            }
        
            root = s.pop();
            arr.add(root.val);

            root = root.right;
        }
        for(int i=1;i<arr.size();i++) {
            if(arr.get(i-1)>=arr.get(i)) {
                return false;
            }
        }
        return true;
    }
}