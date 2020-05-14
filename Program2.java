// Construct binary tree from inorder and preorder
//time o(n)
//space o(n) , n - size of the array 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start>end || index >= preorder.length)
            return null;
        //logic
        int Ridx = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, start, Ridx-1);
        root.right = helper(preorder, Ridx+1, end);
        return root;
    }
}