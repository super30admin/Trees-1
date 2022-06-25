/*
This approach solves the problem by setting a min and max value at each node, propogated from the previous node,
and then checking that the current value of the node is within the range of that minimum and maximum. This approach 
is an iterative implementation, where the recursion stack is manually handled.

Did it run on Leetcode: Yes

Problems with this code: The code is failing at test case [Integer.MIN_VALUE, Integer.MIN_VALUE]

*/
class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(h)
    public boolean isValidBST(TreeNode root) {
        
        //We have three different stacks to store the root, min and max value
        Stack<TreeNode> currStack = new Stack<>();
        Stack<Long> minStack = new Stack<>();
        Stack<Long> maxStack = new Stack<>();
        
        //Long datatype is used because the range of values is from MAX int to MIN int
        long min = Integer.MIN_VALUE - 1;
        long max = Integer.MAX_VALUE + 1;
        
        while(root != null || !currStack.isEmpty())
        {   
            while(root != null)
            {   
                if(max != Integer.MAX_VALUE + 1 && root.val >= max)
                    return false;
                
                if(min != Integer.MIN_VALUE - 1 && root.val <= min)
                    return false;
                
                
                currStack.push(root);
                minStack.push(min);
                maxStack.push(max);
                max = root.val;
                root = root.left;
            }
            
            root = currStack.pop();
            min = minStack.pop();
            max = maxStack.pop();
            
            min = root.val;
            root = root.right;
        }
        
        return true;
    }
}