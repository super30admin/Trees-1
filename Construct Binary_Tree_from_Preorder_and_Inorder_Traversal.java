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
        if(preorder.length == 0){return null;} 
        
        map = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        idx = 0;
        return helper(preorder, inorder, 0 ,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start > end) return null;
        //logic
        //find the root
        
        int rootIdx = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        System.out.println(idx);
        root.left = helper(preorder, inorder, start, rootIdx -1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        return root;
    }
}

//TC : O(N)
//SC : O(H)
