// Time Complexity : O(n) where 'n' is the number of nodes.
// Space Complexity : O(n) where 'n' is the number of nodes.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach:
store indixed of inorder traversal in a map
start iterating preorder, for the val in pre order, the index at which that value occurs is the root
we do recursive calls to call the helper function on left hald and right half of that inorder array (choosing a value from preorder evrytime)
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
class Tree_from_In_Pre {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length ; i++){
                map.put(inorder[i],i);
        }
        return helper(map,0,inorder.length - 1, preorder );
    }
    private TreeNode helper(HashMap<Integer, Integer> map, int start, int end, int[] preorder){
        //base
        if(start > end ) return null;
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(map, start, rootIdx - 1, preorder);
        root.right = helper(map, rootIdx+1,end, preorder);
        return root;
    }
}