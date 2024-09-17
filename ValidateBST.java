/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 98. Validate Binary Search Tree
Time Complexity: O(n)
Space Complexity: O(n)  for the stack: recursive stack
Recursive solution of the level order traversal, the nodes have to be in ascending order, if not return false, Integer because int is primitive type and cant compare with 'null'
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){
        // Base Case
        if(root == null)
            return true;

        if(min != null && root.val <= min)
            return false;

        if(max !=null && root.val >= max)
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }
}

/* 98. Validate Binary Search Tree
Time Complexity: O(n)
Space Complexity: O(n)  for the stack
Recursive solution of the level order traversal, the nodes have to be in ascending order, if not return false. Recursion use a recursive stack and explain
leftmost node, iteratively
min and Max - Iterative and Recursive
Inorder Traversal - Iterative and Recursive
Here we do Iterative Inorder and Recusive of min and max 
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;

        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            if(prev!=null && cur.val <= prev)
                return false;
            prev = cur.val;
            cur = cur.right;
        }
        return true;
    }
}