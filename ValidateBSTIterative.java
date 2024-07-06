// Time Complexity : O(n) => As we are iterating over the n nodes
// Space Complexity : O(h) => As we are using an additional stack to store the nodes which can go up to the height 'h' of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: This is the iterative way where we use an additional stack and a prev pointer. Value of prev pointer is compared with the value of the next node, if it is greater then it indicates it is not a valid BST
 */

class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;

        while(root != null || !s.isEmpty()){

            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();

            if(prev != null && prev.val >= root.val){
                return false;
            }

            prev = root;
            root = root.right;

        }

        return true;
    }
}