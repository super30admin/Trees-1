// Time Complexity : O(n) where n is the number of elements
// Space Complexity : O(h) where h is height at any point,we just consider the recursion stack and at worst case it will be the height
// for a skewed tree it will be O(n) as height = n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// RECURSIVE approach
// we build a helper function which is given params as the current ROOT, the LOW limit and HIGH limit for that particular node.
// our base case is when the root is null we return true since we have reached the end and had no probs until the leaf
// if it is not base case then, we check if our left child is not null and then we see if (root.val>low)... if not return false
// similarly for right 
// if we reached until here ,the current root is fine we need to check recursively for left and right child.. 
// so we return helper(left,low(from parent), root.val) && helper(right,root.val,high( from parent))
//   1<-3->4 so for (left child) 1 our value should lie in[Integer.MIN_VALUE , value of parent]
// and for (right child) 4 our value should lie in[value of parent, Integer.MAX_VALUE ]
// here we use Integer wrapper class and null for Integer represents the limits.

class Solution {
    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);

    }

    private boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;

        return (helper(root.left, low, root.val) && helper(root.right, root.val, high));
    }
}