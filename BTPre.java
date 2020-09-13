// Time Complexity : O(n*n)
// Space Complexity : O(n*n) for recrsive stack, else O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The idea is find the root from the preorder as we know the first element of the preorder is root.
//Traverse inorder for this root and find the index.
//Divide the preorder and inorder such that we know the left and right subtrees in inorder and preorder respectively by using index.
//store those value in 4 new subarrays which are used for building the respective subtrees.
//Use recursion to build the tree from the root towards root.left by using left subtrees in preorder and inorder and vice versa in right.

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(root.val==inorder[i]){
                index = i;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1,inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1,index+1);
        int[] preRight = Arrays.copyOfRange(preorder,index+1,inorder.length);

        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);

        return root;

    }
}