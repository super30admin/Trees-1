//Time complexity-O(n)
//Space complecxity-O(1)
//Did the code run on leetcode- NO 
//Aproach- I was able to come up with a logic around with pointers in both preorder and inorder array. But it was a specific to a single scenario.
            //could not come up with a generic approach.


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
        TreeNode root=preorder[0];
        int pr=1;int in=0;
        TreeNode temp=root;
        while(preorder[1]!=inorder[in])
        {
            temp.left=inorder[in++];
            temp=temp.left;
            pr++;
            
        }
    }
}