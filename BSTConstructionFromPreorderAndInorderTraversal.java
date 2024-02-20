import java.util.*;

// Time Complexity : O(n) - where n is the number of nodes in the preorder or inorder
// Space Complexity : O(1) - O(h) - where h is the height of the BST (Recursive stack space)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:



Fact - > The first element in preorder is always root of BST
         Inorder will be having root in such a way that elements which are left to the root
         forms the left subtree and to the right forms the right subtree.

Constructed the BST by the way inorder traversal. Stored all the inorder elements in
hashmap by index to know the left and right subtree elements by moving the index of
preorder array.

When constructing the right and left subtree elements, to check whether the preorder
root element is falling within the range or not, I've taken start and end index of the
inorder with respect to what element we are dealing with preorder array
 */

class Solution1 {

    private Map<Integer, Integer> indexByInorderRoot;
    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexByInorderRoot = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            indexByInorderRoot.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inorderStart, int inorderEnd) {

        if(inorderStart > inorderEnd) return null;

        int rootVal = preorder[idx++];

        TreeNode root = new TreeNode(rootVal);

        int divider = indexByInorderRoot.get(rootVal);

        root.left = helper(preorder, inorderStart, divider - 1);
        root.right = helper(preorder, divider + 1, inorderEnd);

        return root;
    }
}

public class BSTConstructionFromPreorderAndInorderTraversal {
}
