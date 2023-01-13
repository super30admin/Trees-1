// Approach 1 - Recursion
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We know that for a BST, inorder traversal will be in increasing sorted order
// We can keep track of a lagging pointer(previous pointer) and check if(prev>=cur) it is not a BST and we can return false

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }
    private boolean helper(TreeNode root){
        if(root==null)
            return true;
        boolean left = helper(root.left);
        if(prev!=null && prev.val>=root.val)
            return false;
        prev = root;
        boolean right =  helper(root.right);
        return left && right;
    }
}

// Approach 2 - Iterative
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Same logic as Approach1 but we use a stack to mimic recursive stack in the iterative solution

class Solution {
    Stack<TreeNode> st;
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        st = new Stack<TreeNode>();
        prev = null;
        flag = true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val)
                flag = false;
            prev = root;
            root = root.right;
        }
        return;
    }
}

// Approach 3 - Recursive with limits
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// At each node we have the limits and we check if the node value is within limit else return false
// While recursively calling, if the element is a left child then update max value to parent's else if it is a right child, update min value to parent's

class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null, null);
        return flag;
    }
    private void helper(TreeNode root, Integer min, Integer max){
        if(root==null)
            return;
        if((min!=null && root.val<=min) || (max!=null&&root.val>=max))
            flag = false;
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
        return;
    }
}

// Approach 4 - Iterative with limits
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Same logic as Approach3 but we use a stack to mimic recursive stack in the iterative solution, and 2 separate stacks to keep track of min, max values with a 1:1 mapping

class Solution {
    boolean flag;
    Stack<TreeNode> st;
    Stack<Integer> minSt, maxSt;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        st = new Stack<TreeNode>();
        minSt = new Stack<Integer>();
        maxSt = new Stack<Integer>();
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        Integer min = null;
        Integer max = null;
        st.push(root);
        minSt.push(min);
        maxSt.push(max);
        while(!st.isEmpty()){
            root = st.pop();
            min = minSt.pop();
            max = maxSt.pop();
            if((min!=null && root.val<=min) || (max!=null&&root.val>=max))
                flag = false;
            if(flag==false)
                return;
            if(root.left!=null){
                st.push(root.left);
                minSt.push(min);
                maxSt.push(root.val);
            }
            if(root.right!=null){
                st.push(root.right);
                minSt.push(root.val);
                maxSt.push(max);
            }
        }
        return;
    }
}