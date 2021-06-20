// Time Complexity : O(n)
// Space Complexity : O(n) + O(h) == O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Preorder contains the root node at the very first of the list.
 * we pick the root node by taking the first element from the preorder array and find the left and right subtrees from the inorder array
 * we construct the left and right subtrees for inorder and preorder arrays and recursively call the same function
 * For faster lookups for index in inorder array, we craete a Hashmap for all the inorder elements and the index
 */

class Solution {
    
    Map<Integer, Integer> inorderMap;
        
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // construct Map of inorder elements with index for faster lookup
        inorderMap = new HashMap<>();
    
        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        // base case
        if(pre_start > pre_end) {
            return null;
        }
        
        // Logic
        TreeNode head = new TreeNode(preorder[pre_start]);
        
        int inorder_ind = inorderMap.get(preorder[pre_start]);
        
        int in_st_left = in_start;
        int in_end_left = inorder_ind - 1;

        int pre_st_left = pre_start + 1;
        int pre_end_left = pre_st_left + (in_end_left - in_st_left);
        
        head.left = buildTreeHelper(preorder, inorder, pre_st_left, pre_end_left, in_st_left, in_end_left);
        
        int in_st_right = inorder_ind + 1;
        int in_end_right = in_end;

        int pre_st_right = pre_end_left + 1;
        int pre_end_right = pre_end;
        
        head.right = buildTreeHelper(preorder, inorder, pre_st_right, pre_end_right, in_st_right, in_end_right);
        
        return head;
    }
}
