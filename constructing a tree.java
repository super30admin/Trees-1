//Time complexity:- O(n^2).
//Space complexity:- O(n^2).
//Did it run on leetcode:- yes.
//What problems did you face:- got some errors due to mis indexing.
// write your approach with the code:- pre order first element is root that is stored as value in new node this root value's
// index is found in inorder .after this left braches,rightbranches limits are found and within those limits elements are copied to new arrays and used in recursion.


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
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        
        int pos = 0;
        
        for(int i=0; i<inorder.length;i++) {
            if(inorder[i] == preorder[0]){
                pos = i;
                break;
            }
        }
        
        TreeNode tree = new TreeNode();
        tree.val = preorder[0];
        
        if(pos>0){
            int[] left = Arrays.copyOfRange(inorder, 0, pos);
            tree.left = buildTree(Arrays.copyOfRange(preorder, 1, pos+1), left);
        }
        
        if(pos+1<inorder.length){
            int[] right = Arrays.copyOfRange(inorder, pos+1, inorder.length);
            tree.right = buildTree(Arrays.copyOfRange(preorder, pos+1, preorder.length), right);
        }
        
        return tree;
    }
}
