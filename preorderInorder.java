//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder= root Left right
        //inorder= left root right
        //base case
        if(preorder==null || inorder==null || preorder.length==0)
            return null;
        //taking the root node
        int rootV=preorder[0];
        //to store the root of our tree
        TreeNode root=new TreeNode(rootV);
        //then take the index of root in inroder
        int rootIndex = -1;
        for(int i=0;i<inorder.length;i++){
            if(rootV==inorder[i]){
                rootIndex=i;
                break;
            }
        }
        //an array for inorder left, taking the values from 0th index to index before the root index as left subtree; as well as right subtree
        int[] inorderL=Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderR=Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        //now for preorder left subtree
        int[] preorderL=Arrays.copyOfRange(preorder, 1, rootIndex+1);
        int[] preorderR=Arrays.copyOfRange(preorder, rootIndex+1, preorder.length);
        
        //building left side of the tree
        root.left=buildTree(preorderL, inorderL);
        root.right=buildTree(preorderR, inorderR);
        return root;        
    }
}