// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

import java.util.HashMap;

public class BTFromPreorderAndInorder {
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

    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.idx=0;
        this.map= new HashMap();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);

    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if(start>end) return null;

        int rootVal=preorder[idx];
        idx++;
        int rootIdx=map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left=helper(preorder, start, rootIdx-1);
        root.right= helper(preorder,rootIdx+1, end);

        return root;

    }
}
