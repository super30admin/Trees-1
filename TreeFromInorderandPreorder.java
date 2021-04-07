// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    HashMap<Integer, Integer> hmap;
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        hmap = new HashMap<>();
        // insert all values of inorder in hashmap along with their index to identify
        // their position
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // crosscheck to not overlap the size of array
        if (start > end)
            return null;
        // initialize root node and increment till size of preorder
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        // find the position of root in inorder array
        int idx = hmap.get(root.val);
        // assign a value for the left and right of root
        root.left = helper(preorder, start, idx - 1);
        root.right = helper(preorder, idx + 1, end);
        return root;
    }
}