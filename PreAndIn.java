//Time complexity: O(n)
//Space complexity: O(n)
//Executed on leetcode.
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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        
        TreeNode tree = new TreeNode(preorder[0]);
        int index = -1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==preorder[0])				//Preorder array is stored in root, left and right order. first element is the root.
            {
                index = i;							//In order array is stored in left, root and right order. So the root element is placed such a way all left sub tree values are stored before it and right sub tree values stored after.
                break;
            }										//Based 2 conditions above we divide array and create the tree.
        }
        
        int[] preOleft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preOright = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        int[] inOleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inOright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        tree.left = buildTree(preOleft, inOleft);
        tree.right = buildTree(preOright, inOright);
        
        return tree;
    }
}