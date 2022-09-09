/**
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 
Time Complexity :   O (N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (105. Construct Binary Tree from Preorder and Inorder Traversal)
Any problem you faced while coding this :       No
 */

 // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 class BuildTree {
    HashMap<Integer, Integer> map;
    int idx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if(preorder == null || preorder.length == 0)
            return null;
        
        // to store inorder data and index
        map = new HashMap<Integer, Integer>();
        for(int i =0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
         
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        if(start>end)
            return null;
         
        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);
        idx++;
        
        TreeNode root = new TreeNode(rootVal);   
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        
        return root;
    }
}