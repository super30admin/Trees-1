/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Time Complexity: O(n^2)
Space Complexity: O(n)
Did the code run on leetcode? Yes
Approach: Take first value from the preorder array, which will always be the root for the tree(or subtree). Then, locate this in inorder array and call the location as index. 
*Get the elements from the left of this index in inorder which form the left subtree and do the mirror for the right subtree and call the function recursively
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0 || inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for(int i =0; i<inorder.length; i++){
            if(root.val==inorder[i]){
                index = i;
            break; }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight =  Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inoLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inoRight = Arrays.copyOfRange(inorder, index+1, inorder.length);

        root.left = buildTree(preLeft, inoLeft);
        root.right = buildTree(preRight, inoRight);

        return root;

    }
} 