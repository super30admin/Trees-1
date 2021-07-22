//TC: O(n)
//SC: O(n)
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
    Map<Integer, Integer> inorderMap;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length-1);
        
//         int rootVal = preorder[0];
//         TreeNode root = new TreeNode(rootVal);
        
//         int rootIdx = 0;
//         for(int i=0; i<inorder.length; i++) {
//             if(inorder[i] == rootVal) {
//                 rootIdx = i;
//             }
//         }
        
//         int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
//         int[] preRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);//end index is ignored
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        
//         root.left = buildTree(preLeft, inLeft);
//         root.right = buildTree(preRight, inRight);
        
//         return root;
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        if(start > end) return null;
        
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = inorderMap.get(rootVal);
        
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        
        return root;
    }
}














