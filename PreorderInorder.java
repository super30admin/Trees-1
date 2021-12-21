// Approach 
// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// We use the preorder to get the root value
// we use inorder to determine the left and right children
// we make changes to the arrays and pass them to the recursive functions

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0)
            return null;
        int rootidx = -1;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i])
                rootidx = i;
        }
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inorderright = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);
        int[] preorderleft = Arrays.copyOfRange(preorder, 1, rootidx + 1);
        int[] preorderright = Arrays.copyOfRange(preorder, rootidx + 1, inorder.length);
        root.left = buildTree(preorderleft, inorderleft);
        root.right = buildTree(preorderright, inorderright);
        return root;
    }
}
// Approach
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// We use the preorder to get the root value
// we use inorder to determine the left and right children
// Instead of making changes to the arrays we pass the index and use the Hashmap
// for efficient look up
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0)
            return null;
        map = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);

    }

    public TreeNode helper(int[] preorder, int start, int end) {

        if (start > end)
            return null;

        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootidx = map.get(rootVal);
        root.left = helper(preorder, start, rootidx - 1);
        root.right = helper(preorder, rootidx + 1, end);
        return root;
    }
}