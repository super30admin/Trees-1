// Time Complexity : O(n)
// Space Complexity : O(n) recursive stack space & map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - We know that in inorder, all elements to the left of the index are in left subtree and right are in right subtree. I used this logic along with bounds to solve it. I start with preorder index p (0) -> this gives me root. Now, I keep 2 bounds -> inorder start and end telling me about the bounds for the left and right subtree. I make the new node and left of it will be preorder's next element if it is in bounds start<end. For going left, the left most bound remains the same, the right bound becomes index-1 for inorder. For going right, left most becomes index+1 whereas right remains the same.

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private int p;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrder = new HashMap<>();
        p=0;
        for(int i = 0; i<inorder.length; i++) inOrder.put(inorder[i],i); 
        return helper(preorder, 0, inorder.length-1, inOrder);
    }
    private TreeNode helper(int[] preorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap){
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[p++]); // create a new node. 
        int inorderIndex = inorderMap.get(root.val); // index at which this point is in inorder

        root.left = helper(preorder, inStart, inorderIndex-1, inorderMap); // all elements to the left
        root.right = helper(preorder, inorderIndex+1, inEnd, inorderMap); // all elements to the right

        return root;
    }
}