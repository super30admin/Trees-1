// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //We use a map(key, value) and an integer as global variables. We use recursion with a helper function. In the helper function, we give indexes of preorder array along with the preorder array. 
    //In the map, we store the numbers mapped to their indexes as in inorder array. We intialize global integer variable as "zero", we will use it as the index in preorder array. 
    //We iterate over the preorder, the first number is root. We then look for the index of root in inorder array. Left of the root, we have numbers of left subtree, and vice versa on the right. We recursively call the helper function with these indexes for the left and right sub trees.
    
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

    private Map<Integer, Integer> indexMapOfInorder;
    private int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.indexMapOfInorder = new HashMap<>();
        for (int i=0; i<inorder.length; i++)
        {
            this.indexMapOfInorder.put(inorder[i], i);
        }   
        return helper(preorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int start, int end)
    {
        if (start>=end)
        {
            return null;
        }
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int indexOfRootInInorder = indexMapOfInorder.get(rootVal);
        root.left = helper(preorder, start, indexOfRootInInorder);
        root.right = helper(preorder, indexOfRootInInorder+1, end);
        return root;
    }
}