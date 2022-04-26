/**
Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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

/**
Approach 1: through array copy and searching for root in inorder array
TC: O(n^2)
SC: O(n^2)
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == root.val) {
                rootIdx = i;
                break;
            }
        }
        
        
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1); // Arrays.copyOfRange ignores last element
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }
}

/**
Approach 2: hashmap and pointers in array
TC: O(n)
SC: O(n) for extra space for hash map. Otherwise, it would have been height of tree.
*/
class Solution {
    int preOrderIndex = 0;
    HashMap<Integer, Integer> inorderIndexMap = null;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; ++i) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(root.val) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(root.val) + 1, right);
        return root;
    }
}