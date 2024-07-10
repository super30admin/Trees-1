/*
Tc --> O(n)
Sc --> O(n)
 */
import java.util.*;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

    }

    public TreeNode createTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = map.get(preorder[preStart]);
        int numLeft = idx - inStart;

        //change inorder and preorrder according to the index for left
        root.left = createTree(preorder, preStart + 1, preStart + numLeft, inorder, inStart, idx - 1, map);

        //change the order and preorder according to the index for right
        root.right = createTree(preorder, preStart + numLeft + 1, preEnd, inorder, idx + 1, inEnd, map);

        return root;

    }//method
}//class
