//Time Complexity: O(n)
//Space Complexity: O(n)

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
    static int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<preorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder, inorder, 0, preorder.length-1,map);
    }

    public static TreeNode helper(int preorder[], int inorder[], int start, int end, HashMap<Integer, Integer> map){
        if(start>end || index >= inorder.length)
            return null;
        TreeNode tree = null;
        int i=map.get(preorder[index]);
        tree = new TreeNode(inorder[i]);
        index++;
        tree.left = helper(preorder, inorder, start, i-1, map);
        tree.right = helper(preorder, inorder, i+1, end, map);
        return tree;
    }

}