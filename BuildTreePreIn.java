import java.util.Arrays;

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n^2)
 * Logic: get root node from 0th index of preorder
 *        recursively follow this flow -
     *        check the index of the root node in the inorder array
     *        elements left to this index in the inorder array form the left sub tree
     *        elements right to this index in the inorder arr form the right sub tree
 *            build the inroder and preorder sub arrays for the above left and right sub trees
 *            inorder left sub array will be a copy of inorder array from 0 to root index
 *            inroder right sub array will be a copy of inorder array from root index + 1 to len of inorder arr
 *            preorder left sub array will be a copy of preorder array from 1 to len(inorder left)
 *            preorder right sub array will be a copy of preorder array from len(inorder left + 1) to len of preorder
 *
 *
 */

public class BuildTreePreIn {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //base case
        if(preorder.length == 0){
            return null;
        }

        int rootVal = preorder[0];
        int rootIndx = -1;

        for(int i = 0; i< inorder.length; i++){ //O(n)
            if(rootVal == inorder[i]){
                rootIndx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndx); //O(2n)
        int[] inRight = Arrays.copyOfRange(inorder, rootIndx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;

    }
}
