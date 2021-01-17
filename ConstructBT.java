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
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start > end) return null;
        
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rIdx = map.get(rootVal);
        root.left = helper(preorder, inorder, start, rIdx-1);
        root.right = helper(preorder, inorder, rIdx+1, end);
        return root;
        
    }
}


/*

Need more practice with BST data structure. 

Find the root node in the inorder and preorder arrays
Inorder tells us how many nodes are in the left subtree, as well as right side.
Preorder traversal will have root node as first node in the array.


One traversal not enough, as different trees can have the same pre order traversal.
Brute force time complexity makes N number of recursive calls. and takes O(N^2) runtime and space complexity. 



*/