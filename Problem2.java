/**
 * Time complexity - O(h) where h is the height of the tree
 * Space complexity - O(n*h) where n is the number of elemnts in preorder or inorder array and h for recursive stack
 */
class Solution {
    Map<Integer, Integer> map;
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0) return null;

        map = new HashMap<>();
        int rootVal = preorder[0];
        int idx = -1;
        TreeNode root = new TreeNode(rootVal);

        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i],i);
        }

        return helper(inorder, preorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] inorder, int[] preorder, int start, int end)
    {
        //base
        if(start>end)
            return null;

        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int ridx = map.get(rootVal);
        root.left = helper(inorder, preorder, start, ridx-1);
        root.right = helper(inorder, preorder, ridx+1, end);
        return root;
    }
}