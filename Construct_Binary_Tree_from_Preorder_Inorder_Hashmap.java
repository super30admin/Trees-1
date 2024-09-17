//105. Construct Binary Tree from Preorder and Inorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Time Complexity - O(N), no. of nodes
// Space Complexity - O(NH), height of tree
// Run on leetcode? - yes

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
        if(preorder==null || preorder.length==0)
            return null;
        
        inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        // base
        if(start>end) return null;
        //logic
        // preorder root value
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        
        // inorder root idx
        int rootIdx =  inorderMap.get(rootVal);
        
        // divide left and right subtrees
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        
        return root;
    }
}