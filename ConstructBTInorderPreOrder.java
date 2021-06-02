package Tree1;

import java.util.Arrays;

/* S30 Big N Problem #42 {Medium}- https://www.youtube.com/watch?v=ZfYtnUTI7WE
    You are given a preorder and inorder traversal of a tree and you have to make the binary tree.
    keep in mind that duplicates cannot be there in the tree and try doing this both recursively and iteratively.

    For example, given
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
Source Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n*n)
    space complexity: o(n*n) 
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class ConstructBTInorderPreOrder {
        
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    int idx = -1;    // index of the root in inorder traversal;
    int rootVal = preorder[0];  
    if( preorder == null || preorder.length == 0) return null;
    TreeNode root = new TreeNode();
    root.val = rootVal;
    
    //search inorder travesal for the index where value is equal to rootVal
    
    for(int i=0;i<inorder.length;i++)
    {
        if(inorder[i] == rootVal)
        {
            idx = i;
            break;
        }
    }
    
    
    int[] inorderLeft =  Arrays.copyOfRange(inorder, 0, idx);
    int[] inorderRight =  Arrays.copyOfRange(inorder, idx+1, inorder.length);
    int[] preorderLeft =  Arrays.copyOfRange(preorder, 1, idx+1);
    int[] preorderRight =  Arrays.copyOfRange(preorder, idx+1, preorder.length);
            
     root.left = buildTree(preorderLeft, inorderLeft);
     root.right = buildTree(preorderRight, inorderRight);
    
    
    return root;
    }

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

}
