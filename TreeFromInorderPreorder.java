//Time Complexity:O(n)
//Space Complexity:O(h)
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
    HashMap<Integer,Integer> map;
    int preOrderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.preOrderIndex = 0;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return helper(preorder,0, inorder.length-1,0);
    }

    private TreeNode helper(int[] preorder, int start, int end, int rootIndex){

        if(start > end) return null;
        int rootVal = preorder[preOrderIndex];
        preOrderIndex++;
        rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIndex-1,rootIndex);
        root.right = helper(preorder, rootIndex+1, end,rootIndex);

        return root;
    }
}