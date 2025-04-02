// Time Complexity : O(n) -> visiting each element
// Space Complexity : O(n) -> worst case tree can be linear and no of stacks i.e. height of tree will be n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - first element of preorder is always the root. Use a HashMap to store no and its index from inorder array. calculate nos to left of root using root index from inMap.
//    - Recursively build the left and right subtrees by slicing the preorder and inorder arrays appropriately:
//        * Left Subtree: elements before the root in inorder.
//        * Right Subtree: elements after the root in inorder.
//    - Preorder index is adjusted using the number of nodes in the left subtree.


import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
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

public class ConstructBinaryTreePreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();  //map to hold number and its index in inorder array
        int n = inorder.length;
        for(int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        return __buildTree(preorder, 0, n - 1, inorder, 0, n - 1, inMap);
    }

    private TreeNode __buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) {  //range is empty
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int indexRoot = inMap.get(root.val);    //find index of root in inorder array
        int numsLeft = indexRoot - inStart;     //no of elements left to root i.e. no of elements in left subtree

        //calling recursion and creating left subtree based n modified boundaries of inorder and preorder arrays
        root.left = __buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, indexRoot - 1, inMap);

        //calling recursion and creating right subtree based n modified boundaries of inorder and preorder arrays
        root.right = __buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, indexRoot + 1, inEnd, inMap);

        return root;
    }

    //to print inorder traversal for verification
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    //to print preorder traversal for verification
    public void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorder builder = new ConstructBinaryTreePreorderInorder();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = builder.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of constructed tree:");
        builder.printInorder(root); // Expected: 9 3 15 20 7

        System.out.println("\nPreorder traversal of constructed tree:");
        builder.printPreorder(root); // Expected: 3 9 20 15 7
    }
}
