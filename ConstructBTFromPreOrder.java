package week5;

import java.util.HashMap;
import java.util.Map;

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

public class ConstructBTFromPreOrder {
    int idx=0;
    public TreeNode construct(int[] preorder, int[] inorder){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, map);
    }

    private TreeNode helper(int[] preorder, int start, int end, Map<Integer, Integer> map) {
        if(start>end) return null;
        int rootIndex = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left =  helper(preorder, start, rootIndex-1, map);
        root.right = helper(preorder, rootIndex+1, end, map);
        return root;
    }
}
