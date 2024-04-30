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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>(); //Create a hashmap
        this.idx = 0;
        for(int i = 0; i <= inorder.length - 1; i++){
            map.put(inorder[i], i); //Iterate the inorder array and store it in a hashmap
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end){

        if(start > end) return null;

        int rootVal = preorder[idx]; //The first val of preorder is the root
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rIdx = map.get(rootVal); //Retrieves the value at that index

        root.left = helper(preorder, start, rIdx - 1);
        root.right = helper(preorder, rIdx + 1, end);
        return root;
    }
}