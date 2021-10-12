// Time Complexity :O(n2)
// Space Complexity :O(n) * O(height of the tree)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}
public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    //the first element of preorder array is the root.
    TreeNode root = new TreeNode(preorder[preStart]);

    //Once we have the root, we look for it in the inorder array as the root in order array divides the elements 
    //into left and right subtree i.e all left elements to the root belong to the left subtree
    //and vice versa
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    //We can find the length of the left an dthe right subtree from the inorder array once we have the root
    //we can simply subtrcat the index from instart to get the left subtree's length
    //and index + 1 to inend to find the length of the right subtree. Accordingly, we adjust the 
    //boundaries
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
}