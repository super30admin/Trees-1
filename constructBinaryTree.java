/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val)j { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/* 
//Tc: O(n)  Sc: O(n)
class Solution {
    int index;
    HashMap<Integer, Integer > map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length; i++)
        {
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end)
    {
        if(start >end) return null;
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}
*/