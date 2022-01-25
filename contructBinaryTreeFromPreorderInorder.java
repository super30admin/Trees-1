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
    int preIndex; // postorder index for iterating root
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //nullcase
        if(preorder == null || preorder.length == 0)
            return null;
        
        //logic
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        //baseCondition
        if(start > end)
            return null;
        
        //logic
        int rootVal = preorder[preIndex];
        preIndex++;
        
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        
        //T.C - O(N) S.C - O(N)
        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        
        return root;
    }
}
