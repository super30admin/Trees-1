//TC: O(N)
//SC:O(N)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int [] current = {0};
        
        TreeNode root;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return(buildTree(preorder, current, 0, preorder.length - 1, map));
        
    }
    public TreeNode buildTree(int[] preorder, int[] current, int low, int high, Map<Integer, Integer> myHash){
        if (current[0] >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[current[0]]);
        if (low > high) return null;
        else {
            current[0] += 1;
            int i = myHash.get(root.val);
            root.left = buildTree(preorder, current, low, i - 1, myHash); 
            root.right = buildTree(preorder, current, i + 1, high, myHash);
            }
        return root;
    }
}