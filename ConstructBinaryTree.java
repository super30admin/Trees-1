// Time Complexity - O(n)
// Space Complexity - O(n)

import java.util.HashMap;

public class ConstructBinaryTree {

    public static class TreeNode {
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

    // HashMap approach
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        //null
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for (int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return  helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // base
        if (start>end) return null;

        // logic
        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);
        return root;
    }
}
