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
// Approach - 1
// Executed
// T.C: O(n power 2)
// S.C: O(n)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        int rootVal = preorder[0];
        TreeNode node = new TreeNode(rootVal);
        // node.add(rootVal);
        int rootidx = -1;
        // Trying to find left and right subtree based on root in inorder
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootidx = i;
                break;
            }
        }
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);
        // Preorder will start from 1 because 0 is the root
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootidx+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootidx+1, preorder.length);
        
        node.left = buildTree(preorderLeft, inorderLeft);
        node.right = buildTree(preorderRight, inorderRight);
        
        return node;
    }
}

// Approach - 2
// Executed
// T.C: O(n)
// S.C: O(n)
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) 
            return null;
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        
        return root;
    }
}
