/*
 * Time Complexity : O(n^2)
 * Space Complexity :  O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - Since we are given preorder, the first element is the root of the tree. We then create a map with the elements in inorder along with their indices to create the root's 
 * left inorder and preorder and the root's right inorder and preorder. For every  node we recursively pass it's inorder array and pre order array for its left and right child. 
 */

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
class ConstructBTWithInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if(preorder.length==0)return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int idx= map.get(rootVal);
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder,inLeft.length+1,preorder.length);

        root.left= buildTree(preLeft,inLeft);
        root.right=buildTree(preRight,inRight);
        return root;
    }
}