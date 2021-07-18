// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        
        //find root from preorder
        int rootVal = preorder[0];
        
        //the first node of the tree is the root found from preorder
        TreeNode root = new TreeNode(rootVal);
        
        //search root index in inorder
        int rootIdx = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
            }
        }
        
        //4 subarrays
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx); //end index is ignored so we don't do rootIdx - 1
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}