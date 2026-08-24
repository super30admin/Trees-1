//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//O(n) space complexity
//O(1) time complexity



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
     HashMap<Integer,Integer> map = new HashMap<>();

    int index;

    TreeNode root;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
index = 0;
       

        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length -1);
        
        
    }

    public TreeNode helper( int[] preorder, int start, int end){

        if(start>end) {
            return null;

        }

    

        int rootVal = preorder[index];
        index++;

        int rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        //left
        root.left = helper(preorder, start, rootIndex-1 );


        root.right = helper(preorder, rootIndex+1, end);

        return root;

        




    }
}
