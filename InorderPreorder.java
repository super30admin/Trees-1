// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> store = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            store.put(inorder[i],i);
        }
        return helper(0,0,inorder.length-1,preorder, inorder,store);            
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,HashMap<Integer, Integer> store){
        if(preStart > inorder.length-1 || inStart > inEnd)
            return null;
        //gives root of the tree
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        // for(int i=inStart;i<=inEnd;i++){
        //     if(inorder[i] == root.val){
        //     inIndex = i;
        // }}
        //get index of root in inorder map
        inIndex = store.get(root.val); 
        //left subtree
        root.left = helper(preStart+1,inStart,inIndex-1,preorder,inorder,store);
        //right subtree
        root.right = helper(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder, inorder,store);
            
        return root;
    }
}