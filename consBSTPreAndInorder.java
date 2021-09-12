import java.util.HashMap;

import javax.swing.tree.TreeNode;

//Time: O(n)
//Space: O(n)

/**
 * Preorder will give us the root, need to check check which index we at for the preorder traversal
 * We can map the inorder array to a HashMap to make the lookup constant time and construct a tree
 * using recursive calls on subtrees split into left and right from the root
 */

public class consBSTPreAndInorder {
    int preorderArrIdx;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderArrIdx = 0;
        //map inorder array to hash map
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1); //int array from 0 to last index
    }

    //Building the tree
    private TreeNode helper(int[] preorder, int left, int right) {
        int rootVal;
        if(right < left) return null;

        rootVal = preorder[preorderArrIdx++];
        TreeNode root = new TreeNode(rootVal);

        root.left  = helper(preorder, left, map.get(rootVal) - 1);
        root.right = helper(preorder, map.get(rootVal) + 1, right);

        return root;
    }
}
