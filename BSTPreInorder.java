// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class BSTPreInorder {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(inorder.length==1)
            return new TreeNode(inorder[0]);
        
        int i = 0;
        for(int num : inorder)
            map.put(num, i++);
        
        
        return construct(0, inorder.length-1, preorder);
    }
    
    public TreeNode construct(int start, int end, int[] preorder) {
        
        if(start>end)
            return null;

        int parent = preorder[index++];
        TreeNode root = new TreeNode(parent);
        
        int pIndex = map.get(root.val);
    
        root.left = construct(start, pIndex-1, preorder);
        root.right = construct(pIndex+1, end, preorder);
        
        return root;
    }
}
