
/*
Time Complexity :  O(n^2) where finding the index is O(n) and buildig the arrays is O(n).
Space Complexity: O(1) as we are not using any extra auxillary space.
Worked on leetcode.
*/
import java.util.*;

class Solution {
    TreeNode root;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // base case
        if (preorder == null || preorder.length == 0)
            return null;

        // storing root val
        int rootval = preorder[0];
        // creating the node

        TreeNode root = new TreeNode(rootval);

        int idx = -1;
        // finding the index
        for (int i = 0; i < inorder.length; i++) {

            if (inorder[i] == rootval) {

                idx = i;
            }

        }
        // building the array
        int inleft[] = Arrays.copyOfRange(inorder, 0, idx);
        int inright[] = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        int preleft[] = Arrays.copyOfRange(preorder, 1, idx + 1);
        int preright[] = Arrays.copyOfRange(preorder, idx + 1, preorder.length);

        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);

        return root;

    }

}