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
    int preInd = 0;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preInd = 0;
        inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        System.out.print(inorderMap);
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left > right)
            return null;
        
        int rootval = preorder[preInd++];
        TreeNode root = new TreeNode(rootval);
        root.left = arrayToTree(preorder, left, inorderMap.get(rootval) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootval) + 1, right);
        return root;
        
        
        
        
    }
   
}