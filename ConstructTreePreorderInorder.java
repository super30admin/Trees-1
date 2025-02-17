//The approach here is to use pointers to create subarray for the inorder array for the left and right of the root index.
//We find the root index using the pre-order array. In every recrusive call, we increase the idx by 1, which gives the new root that is used to find the root index.
//Time Complexity: O(n)
//Space complexity: O(n)

import java.util.HashMap;

class TreeNode {
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

class Solution {
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, -1, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int rootIdx, int start, int end){
        //basecase
        if(start > end){
            return null;
        }
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        rootIdx = map.get(root);

        root.left = helper(preorder, rootIdx, start, rootIdx-1);
        root.right = helper(preorder, rootIdx, rootIdx+1, end);

        return root;
        
    }
}
