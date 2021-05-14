// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We form the Tree in a recursive manner using a map to keep track of the indices in the InOrder Array.
    Further, we increment the index of the PreOrder Array during each recursive call.
    The start and end pointers are used to define the size of the SubTree we are forming. 
*/

class Solution {
    Map<Integer,Integer> hashMap;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        hashMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) hashMap.put(inorder[i],i);
        idx = 0;
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if (start>end) return null;
        
        int val = preorder[idx];
        idx++;
        int inIdx = hashMap.get(val);
        TreeNode root = new TreeNode(val); 
        root.left = helper(preorder, inorder, start, inIdx-1);
        root.right = helper(preorder, inorder, inIdx+1, end);
        return root;
    }
}