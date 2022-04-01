// Time Complexity : O(n) n is number of nodes
// Space Complexity : O(n) space fro hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
class Solution {

    //to search index of root in inorder array
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    //preorder is root-left-right, so this array will give us the root of trees and subtrees

    //when we find the root from preorder, we search for this in inroder and get its index from inorder array

    //inorder is left-root-right, so this array will give us the left and right subtree of the roots which we found from preorder

    //in inorder array, everything left of root will be left subtree and everything to the right of root will be the right subtree

    //we can then build the subtrees using recursion

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        if(inorder==null || preorder == null || inorder.length != preorder.length)
            return null;

        int n = inorder.length;

        //put inorder vals and indices in hashmap
        for(int i=0; i<n; i++)
            inorderIndexMap.put(inorder[i], i);

        //initial recursion values - whole arrays
        return recursion(inorder, 0, n-1, preorder, 0, n-1);

    }

    public TreeNode recursion(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {

        //our pointers cross each other - we are done with whole arrays
        if(inStart > inEnd || preStart > preEnd)    return null;

        //root is first index of preorder
        int rootVal = preorder[preStart];

        //make a node for this root
        TreeNode root = new TreeNode(rootVal);

        //find at which index is root in inorder array
        int rootIndex = inorderIndexMap.get(rootVal);

        //everything to the left of root in inorder array is the left subtree
        //we need to calculate start and end indices (pointers) of inorder and preorder portions of this subtree now
        //start index of preorder will be next of root in preorder
        //end index of preorder will be prestart + length(left subtree vals in inorder array)

        TreeNode leftChild = recursion(inorder, inStart, rootIndex-1, preorder, preStart+1, preStart + rootIndex - inStart);

        //everything to the right of root in inorder array is the right subtree
        //we need to calculate start and end indices (pointers) of inorder and preorder portions of this subtree now
        //start index of preorder will be where end of preorder of left subtree ended +1 = length(left subtree vals in preoder) + 1
        //end index of preorder will be end of preorder array

        TreeNode rightChild = recursion(inorder, rootIndex+1, inEnd, preorder, preStart + rootIndex - inStart + 1, preEnd);

        //make these nodes the left and right subtree roots
        root.left = leftChild;
        root.right = rightChild;

        return root;

    }

}
