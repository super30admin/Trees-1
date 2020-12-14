// Time Complexity :O(N) where n is the number of nodes 
// Space Complexity :O(H) where H is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:Storing the node in the stack and while popping checking it with the previous
//popped element. if it is smaller than the prevous node value then it is not a valid binary tree.
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
        if(root == null)
            return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode previous = null;
        while(!s.isEmpty()||root != null){
            while(root!=null){
            s.push(root);
            root = root.left;
        }
        root=s.pop();
        if(previous!=null && root.val<=previous.val)
            return false;
        previous=root;
        root=root.right;
        }
        return true;
    }
}