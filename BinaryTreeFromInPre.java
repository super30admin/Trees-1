// Time Complexity - O(n)
// Space Complexity - O(h)

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
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        idx = 0;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        // base
        if(start>end) return null; //why return null
        // logic
        int preRoot = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(preRoot);
        int inRootIdx = map.get(preRoot);
        root.left = helper(preorder,start,inRootIdx-1);
        root.right = helper(preorder,inRootIdx+1,end);
        return root;
    }

}