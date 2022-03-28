// Time Complexity : O(n)
// Space Complexity : O(n) - for map
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreOrderAndInorder {

    public class TreeNode {
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

    int index = 0;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0 , preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end) return null;

        //logic
        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        index++;
        //find root in inorder
        int rootIndex = map.get(rootVal);

        //left subtree
        root.left = helper(preorder, start, rootIndex-1);
        //right subtree
        root.right = helper(preorder, rootIndex+1,end);
        return root;
    }
}
