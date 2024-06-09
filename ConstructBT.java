/***
 TC - O(n)
 SC - O(h)
 */

import java.util.HashMap;
import java.util.Map;



class ConstructBT {

    Map<Integer, Integer> hm;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        //Using hashmap to map inorder array elements to its index
        hm = new HashMap<>();
        for(int i =0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return recurse(preorder, 0, inorder.length-1);
    }

    public TreeNode recurse(int[] preorder, int start, int end) {
        //base condition
        if(start > end)
            return null;

        int rootVal = preorder[idx++];

        TreeNode root = new TreeNode(rootVal);

        int rootIdx = hm.get(rootVal);

        root.left = recurse(preorder, start, rootIdx-1);
        root.right = recurse(preorder, rootIdx+1, end);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}