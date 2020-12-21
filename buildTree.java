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

//TC: O(N)
//SC: O(N)
class Solution {
    HashMap<Integer, Integer> inorderMap;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        if (inorder == null || inorder.length == 0){
            return null;
        }
            
        inorderMap = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        index = 0;
        return helper(preorder, 0, inorder.length -1);
    }
    private TreeNode helper(int [] preorder, int start, int end) {
        if (start > end){
            return null;
        }
            
        //Find Value in the root which is the first element in preorder list
        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        //if present update the index and break the loop
        index ++;
        //Check the inorder array where the root value is present
        int rootIndex = inorderMap.get(rootVal);

        //left part of the preorder array
        root.left = helper(preorder, start, rootIndex-1);
        //right part of the preorder array
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}
