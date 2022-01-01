// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Preorder array gives us root node in each level. 
 * Inorder array gives us left and right subtree for each level.
 * In each iteration, we make root node from element of preorder and search that element in inorder array.
 * to form left and right subtree and move ahead. Since we have preorder array, we will construct left subtree and then right subtree for each node
 * We use class variable int idx to keep a track of current element of preorder array to form root node and hashmap to make lookup in constant time.
 * In our helper function, whenever start becomes greater than end, this is the case where we return null as we have reach leaf node.
*/

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
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || inorder.length == 0)return null;
        map = new HashMap<>();
        
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i], i);
        }
       return helper(preorder, 0, inorder.length - 1); 
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start > end){
            return null;
        }
        
        //logic
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        int rootIdx = map.get(root.val);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx + 1, end);
        
        return root;
    }
}