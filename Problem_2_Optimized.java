//  Time complexity - O(n)
// Space complexity - O(h)

// Use hashmap for getting inorder index and eliminate o(N) complxity oin each recursive call!

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
    Map<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0 ; i< inorder.length; i++){
            map.put(inorder[i],i );
        }
        return helper(preorder,inorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder,int start, int end){
        // base
        
        if(start > end || index > preorder.length){
            return null;
        }
        
        // logic
        TreeNode root = new TreeNode(preorder[index]);
        int inIdx = map.get(root.val);
        index++;
        
        root.left = helper(preorder,inorder,start,inIdx-1);
        root.right = helper(preorder,inorder,inIdx+1,end);
        return root;
        
    }
}
