/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return buildTreeRec(preorder, inorder, 0 , inorder.length-1);
    }

    private TreeNode buildTreeRec (int[] preorder , int[] inorder , int inStart , int inEnd)
    {
        if(inStart > inEnd)
        {
            return null;
        }
        //rec
        int val = preorder[preIndex];
        int index = getIndex(inorder, inStart, inEnd, val);
        ++preIndex;

        TreeNode  root = new TreeNode(val);
        root.left = buildTreeRec(preorder, inorder, inStart, index-1);
        root.right = buildTreeRec(preorder , inorder, index+1 ,inEnd);

        return root;
    }

    private int getIndex(int [] arr ,int start, int end ,int val)
    {
        for (int i = 0 ; i < arr.length ; ++i)
        {
            if (arr[i] == val)
            {
                return i;
            }
        }
        return -1;
    }


}

