/**
// Time Complexity: O(n)
// Space Complexity: O(1). But, since this is a recursion, it could be considered O(n) depending on how big the stack is
// Solved on Leetcode successfully: Yes
// Approach: Use Recursion
// First element of preorder is root. Because preorder is root-->left-->right
// Search this root in inorder array
// Form inorder and preorder recursively
// Form left and right of the root
//Return root

* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length ==0) return null;
        int index =-1;
        TreeNode root = new TreeNode(preorder[0]);
        
        
        for(int i=0; i<inorder.length;i++) {
            
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        int [] inLeft = Arrays.copyOfRange(inorder,0,index);
        int [] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int [] preLeft = Arrays.copyOfRange(preorder,1,index+1);
        int [] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight,inRight);
        return root;
    }
}