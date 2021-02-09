/**
T: O(n2)
S: O(n) for Hashmap Space + O(n2) -> o(n2)



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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        
        //create map to find root index in inorder array
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildBinaryTree(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode buildBinaryTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        //base case
        if(inStart > inEnd)
            return null;
        
        //find root
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(root.val);
        
        root.left = buildBinaryTree(preorder, inorder, preStart + 1, inStart, index - 1);
        root.right = buildBinaryTree(preorder, inorder, preStart + (index - inStart + 1), index + 1, inEnd);
        return root;
    }
}