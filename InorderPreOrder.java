/*
* Approach:
*  1. Store all the inorder values into hashmap,
         for efficient index search.
* 
*  2. Maintain four pointers, 
        preStart and preEnd for preorder array
        inStart and inEnd for inorder array.

    Get the root from preorder array using preStart

    Find the rootIndex in inorder using hashmap.
* 
*  3. Count number of element that need to be skipped in
        preorder array for left and right subtrees.
    
        recursively call the left and right using the 
        updated preorder and inorder ranges 
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
    use of hashmap
* 
*/

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};

public class InorderPreOrder {
    private TreeNode helper(int[] preorder, int[] inorder,
            Map<Integer, Integer> hmap, int preStart,
            int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = hmap.get(preorder[preStart]);

        int numsElem = rootIndex - inStart;

        root.left = helper(preorder, inorder, hmap,
                preStart + 1, preStart + numsElem,
                inStart, rootIndex - 1);

        root.right = helper(preorder, inorder, hmap,
                preStart + numsElem + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int index = 0; index < inorder.length; index++) {
            hmap.put(inorder[index], index);
        }

        return helper(preorder, inorder, hmap, 0,
                preorder.length - 1, 0, inorder.length - 1);
    }
}
