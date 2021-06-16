// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

// Use recursion to create the Binary Tree from the given 2 traversals
// The first element in the preorder will always be the root and the elements to left of it in the inorder array
// will be a part of the left subtree and the elements to the right of the root in the inorder array will be a part of the right subtree
class Solution {
    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++) {
            inOrderIndexMap.put(inorder[i],i);
        }
        
        return buildBST(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode buildBST(int[] preorder, int start, int end) {
        if(start > end)
            return null;
        
        int rootValue = preorder[preOrderIndex++];
        int inOrderIndex = inOrderIndexMap.get(rootValue);
        
        TreeNode root = new TreeNode(rootValue);
        root.left = buildBST(preorder, start, inOrderIndex-1);
        root.right = buildBST(preorder, inOrderIndex+1, end);
        
        return root;
    }
}