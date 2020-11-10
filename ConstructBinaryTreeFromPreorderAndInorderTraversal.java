package S30.Trees_1;

/*
Time Complexity : O(n) - touching every node
Space Complexity : O(n)[hashmap size] + O(h)[stackframe height]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    int preorderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return build(preorder,inorder,0,inorder.length-1);

    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right){

        if(left > right) return null;

        int root = preorder[preorderIdx];
        TreeNode node = new TreeNode(root);
        preorderIdx ++;

        int inorderIdx = map.get(root);

        node.left = build(preorder,inorder,left,inorderIdx-1);
        node.right = build(preorder,inorder,inorderIdx+1,right);

        return node;
    }
}
