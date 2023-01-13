// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// In Preorder first element will always give us root
// Once we have the value of root, we can search for it in inorder array, and we get get left and right subtree split
// For each of these subtrees we can recursively find root, left and right subtree and move down the tree till we reach a leaf node

class Solution {
    HashMap <Integer, Integer> map;
    int rootIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        rootIdx = 0;
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i],i);
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        int index = -1;
        if(start>end)
            return null;
        TreeNode rootNode = new TreeNode(preorder[rootIdx]);
        rootIdx++;
        index = map.get(rootNode.val);
        rootNode.left = helper(preorder, inorder, start, index-1);
        rootNode.right = helper(preorder, inorder,index+1, end);
        return rootNode;
    }
}