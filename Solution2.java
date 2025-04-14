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

//preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// root = 3 inLeft = [9] preLeft = [9]

//root = 3 inRight = [15,20,7] preRight = [20,15,7]

//root = 20 inLeft=[15] preLeft=[15]

// inRight = [7] preRight = [7]


class Solution2 {
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();

        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, 0, preorder.length-1);
    }

    private TreeNode helper(int[] preorder,int i,  int left, int right)
    {
        if (left > right) return null;

        int rootValue = preorder[i];
        TreeNode root = new TreeNode(rootValue);
        int index = map.get(root.val);
        root.left = helper(preorder,i+1, left, index -1 );
        root.right = helper(preorder,i+(index-left+1),index+1, right);

        return root;

    }
}