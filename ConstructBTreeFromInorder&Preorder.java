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

//TC: O(n^2)
//SC: O(n^2), n: number of nodes in the tree
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        int rootVal = preorder[0]; int rootIdx = -1;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}

//TC: O(n)
//SC: O(n), n: number of nodes in the tree
class Solution {
    Map<Integer, Integer> map;
    int idx = 0; //pointer for index in preorder traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }        
        return helper(preorder, inorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(idx == preorder.length || start > end) return null;
        
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal); //rootIdx: index of root in inorder traversal
        TreeNode root = new TreeNode(rootVal);
        
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }
}
