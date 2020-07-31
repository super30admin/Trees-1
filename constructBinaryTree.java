/**
Problem : Construct a binary tree given inorder and preoder traversal.
Did it run on leetcode : yes

Time Complexity : O(n^2), for brute force, and O(n) for optimal solution where n is the number of nodes in the tree
Space Complexity : For brute force solution, O(n^2), and for optimal solution O(1), where n is the number of nodes in the tree.

Approach 1: 
1. We know that root lies in the first position in preorder traversal.
2. We find the corresponding index position of root in inorder traversal and elements to the left of it form the left subtree, and elements to the right form the right subtree.
3. We recursively keep passing the left and right subarrays to the tree and in the end, return the root, which gives us the whole tree.

Approach 2: 2 pointers
1. Here, we optimize the time and space complexity of the above solution by using 2 pointers.
2. We place the elements of inorder array in the hashmap and then get the corresponding position of the root from it.
3. Once we get that, as we already know that elements to the left of root form left subtree, and right of root form right subtree, we recursively build the left and right subtrees by using the start and end pointers.

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

//Recursive solution - Arrays
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        //TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                index = i;
            }  
        }
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}

//Recursive solution - 2 pointers 
class Solution {
    HashMap<Integer,Integer> hm;
    int preRootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) {
            return null;
        }
        hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return getTree(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode getTree(int[] preorder, int[] inorder, int start, int end) {
        if(preRootIndex == preorder.length || start > end) {
            return null;
        }
        int inRootIndex = hm.get(preorder[preRootIndex]);
        TreeNode root = new TreeNode(preorder[preRootIndex]);
        preRootIndex++;
        root.left = getTree(preorder, inorder, start, inRootIndex-1);
        root.right = getTree(preorder, inorder, inRootIndex + 1, end);
        return root;
    }
    
}