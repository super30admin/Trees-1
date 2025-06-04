/*
Time Complexity: O(N) where N is the number of nodes in the tree.
Space Complexity: O(h) where h is the height of the tree.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Intuition: 
A - Identify the Root:
The first element of the preorder traversal is always the root of the tree.

B - Split the Inorder Array:
Find the index of the root in the inorder traversal. This index helps you determine 
which elements belong to the left and right subtrees.
Elements to the left of this index in the inorder array belong to 
the left subtree, and elements to the right belong to the right subtree.

C - Recursive Construction:
Recursively apply the same logic to construct the left and right subtrees
 using the corresponding segments of the preorder and inorder arrays.
*/

public class BinaryFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        if (preStart > inorder.length || inStart > inEnd)
            return null;
        int rootFromInorder = 0;
        for (int i = inStart; i <= inEnd; i++) { // getting root and index
            if (preorder[preStart] == inorder[i]) {
                root.val = preorder[preStart];
                rootFromInorder = i;
            }
        }

        root.left = helper(preStart + 1, inStart, rootFromInorder - 1, preorder, inorder);
        root.right = helper(preStart + (rootFromInorder - inStart) + 1, rootFromInorder + 1, inEnd, preorder, inorder);

        return root;

    }

    public static void main(String[] args) {
        BinaryFromPreorderInorder solution = new BinaryFromPreorderInorder();
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }
}