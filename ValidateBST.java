// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No

//Iterartive
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;

        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

//Recursive

// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No

class Solution {

    public boolean isValidBST(TreeNode root) {

        return isValid(root, null, null);

    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {

        if(root == null) {
            return true;
        }

        if(min != null && root.val <= min){
            return false;
        }

        if(max != null && root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);

    }
}