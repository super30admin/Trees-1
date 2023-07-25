//Time complexity: O(n) 
//Space Complexity: O(n) for hashmap, for stack is height of tree, taking max of two = O(n)

import java.util.HashMap;

import javax.swing.tree.TreeNode;

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<Integer, Integer>();
        for(int i =0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length-1, map.get(preorder[0]));
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end, int rootIdx){

        if(start>end) return null;

        int rootVal = preorder[idx]; //gives the value of root element from preorder array
        idx++; //will give enxt root from pre-order traversal

        rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);


        root.left = helper(preorder, inorder, start, rootIdx-1, rootIdx);
        root.right = helper(preorder, inorder, rootIdx+1, end, rootIdx);
        return root;

    }
}