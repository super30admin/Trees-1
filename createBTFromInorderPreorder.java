// Time Complexity : O(n)
// Space Complexity : O(n) since it uses a HashMap to optimize lookup
// Did this code successfully run on Leetcode : Yes

/*

Approach:
We always need 2 traversals in order to construct a unique tree.
Here, we are given an inorder and a preorder traversal.
Observation - preorder traversal always has the root node of the entire tree as 
the first element, and so on for all subsequent subtrees.
We take advantage of this fact to contstruct our tree recursively.
In order to find the left and right subtrees, we find the index of the root 
node in the inorder array, and consider that the left of the root node in the 
inorder array is the left subtree, and the right of the inorder array is the 
right subtree, taking the root as the middle.
In order to optimize the lookup of the root node in the inorder array, we use a 
HashMap to store all elements and indices from the inorder array.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> m;
    int index; // initially 0, always tracks root node of subtrees

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 ||
        inorder == null || inorder.length == 0) {
            return null;
        }

        // create a HashMap to optimize lookup of root node in inorder traversal array
        m = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            m.put(inorder[i], i);
        }

        // then use preorder to construct tree by keeping
        // pointers for start and end of each subtree.
        // initially the subtree is the entire tree, so start and end
        // are 0 and len-1
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        
        // fetch from inorder array so that left and right subtrees can
        // be created from a split inorder array
        int rootIndex = m.get(rootVal); 

        root.left = helper(preorder, start, rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);

        return root;
    }
}