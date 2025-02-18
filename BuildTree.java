//Time complexity: O(n)
//Space complexity: O(n)

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

    Map<Integer, Integer> map;
    int[] preorder;
    int[] inorder;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;
        this.inorder = inorder;
        this.idx = 0;

        //we will store the index of inorder values
        this.map = new HashMap<>();

        //store inorder values and the index
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //we will pass the low and high range to find the element from inorder array
        return helper(0, inorder.length - 1); 
    }

    public TreeNode helper(int left, int right) {

        //base condition
        if(left > right)
            return null;

        //first node in preorder will always be the root, but it will be in the center for inorder array
        int val = preorder[idx++];
        TreeNode t = new TreeNode(val);

        //find the index of middle element, so that we can search on left for left subtree and right side for right subtree
        int mid = map.get(val);

        //elements to left of the root will be left subtree 
        t.left = helper(left, mid - 1);

        //elements to right of the root will be left subtree 
        t.right = helper(mid + 1, right);
        return t;
    }
}