// Space Complexity: O(n)
// Time Complexity: O(n)

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
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int sIndex, int eIndex){
        if(sIndex > eIndex) return null;
        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        index++;
        int rootIndex = map.get(rootVal);
        root.left = helper(preorder, sIndex, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, eIndex);
        
        return root;
        
    }
}