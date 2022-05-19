// Time Complexity :O(h) - height of tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart>preorder.length-1 || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(root.val==inorder[i]){//you iterate through and check if preorder value is same as inorder
                index = i;//if so you store in index
                System.out.println(i);
            }
        }
        //you use the index to decide the left root and right root
        root.left = helper(preStart+1, inStart, index-1, preorder, inorder);
        root.right = helper(preStart+index-inStart+1, index+1, inEnd, preorder, inorder);
        return root;
    }
}