// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
We are using recursion to solve this one
first we create the Hashmap of inorder array, where array values are keys and index values are values

we call the helper fuction on preorder(root,left right) so we adding values from preorder as our function is also root,left,right
when are reach start > end over tree is built
*/

class Solution {
    int idx; // preorder idx
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // base
        if (start > end)
            return null;

        // logic
        int rootval = preorder[idx];
        idx++;
        int rootidx = map.get(rootval);
        TreeNode root = new TreeNode(rootval);

        root.left = helper(preorder, start, rootidx - 1);
        root.right = helper(preorder, rootidx + 1, end);
        return root;
    }
}