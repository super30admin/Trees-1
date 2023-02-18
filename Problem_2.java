// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use preorder array to get the root. Then using the inorder array we get the left and right subtrees. 
   To optimize on lookup in inorder array we use a hashmap. On getting the index we call function recursively on 
   left and right subtrees and repeat till we construct the whole tree.
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
    int preOrderIndex;
    Map<Integer, Integer> hMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        hMap = new HashMap<>();

        for(int i = 0; i < inorder.length; ++i) {
            hMap.put(inorder[i], i);
        }

        return buildTre(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTre(int[] preorder, int left, int right) {
        if(left > right)
            return null;

        int root = preorder[preOrderIndex++];

        TreeNode r = new TreeNode(root);
        r.left = buildTre(preorder, left, hMap.get(root) - 1);
        r.right = buildTre(preorder, hMap.get(root) + 1, right);

        return r;
    }
}