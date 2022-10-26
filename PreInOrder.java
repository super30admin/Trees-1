
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


import java.util.HashMap;

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
    public class PreInOrder {

        public int preIndex;
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preIndex = 0;
            this.preorder = preorder;
            this.inorder = inorder;
            for (int i= 0 ; i <= inorder.length - 1; ++i){
                map.put(inorder[i], i);
            }
            return buildTree(0, preorder.length -1);

        }

        public TreeNode buildTree(int start, int end){

            if(start > end){
                return null;
            }

            TreeNode node = new TreeNode(preorder[preIndex]);
            preIndex++;

            if(start == end) return node;

            int index = map.get(node.val));
            node.left = buildTree(start, index-1);
            node.right = buildTree(index + 1, end);
            return node;
        }

    }

