// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int sumNumbers(TreeNode root) {
        // return 0 if tree is empty
        if(root == null) return 0;
        // intialize parallel stacks
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        // initialize num and sum variables
        int num = 0; int sum = 0;
        // iterate through the tree
        while(root != null || !st.isEmpty()){
            // keep pushing the left child nodes in stack
            // keep pushing the updated sum at each node in stack
            while(root != null){
                st.push(root);
                num = num * 10 + root.val;
                numStack.push(num);
                root = root.left;
            }
            // when null element is hit, pop elements from both stacks
            root = st.pop();
            num = numStack.pop();
            // in case of leaf element, update the sum
            if(root.left == null && root.right == null) sum += num;
            // do the same for children nodes on right
            root = root.right;
        }
        return sum;
    }
}