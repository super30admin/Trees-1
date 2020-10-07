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
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> index_map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        
        int idx = 0;
        for(int val : inorder){
            index_map.put(val, idx++);
        }
        return helper(0, inorder.length -1);
    }
    
    private TreeNode helper(int left, int right){
        //Base case-
        if(left > right) return null;
        //Get the root node value
        int root_val = preorder[pre_idx++];
        //Create a new treenode
        TreeNode root= new TreeNode(root_val);
        // Get the index in inorder so that left and right nodes of current node can         // be traversed
        int index = index_map.get(root_val);
        
        root.left = helper(left, index-1);
        root.right = helper(index+1, right);
        
        return root;
        
    }
}

// TC- O(n)
//SC- O(N)
