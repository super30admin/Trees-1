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

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get the hashmap for inorder tree, and then find the rootnode and its index from the root value
// traverse to the left part of the inorder list and right part of the inorder list and assign it to the right and left of the root node
// Your code here along with comments explaining your approach
class Solution {
    int idx;
    HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // null
        if( preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++ ){
            hm.put(inorder[i], i);
        }
        return getTree(preorder, 0, inorder.length-1);
    }
    private TreeNode getTree(int[] preorder, int start, int end){
        // base
        if(start > end)
            return null;
        // logic
        int rootVal = preorder[idx];
        TreeNode rootNode = new TreeNode(rootVal);
        idx++;
        int rootIndex = hm.get(rootVal);
        rootNode.left = getTree(preorder,start,rootIndex-1);
        rootNode.right = getTree(preorder,rootIndex+1,end);
        return rootNode;
    }
}


// Time Complexity : O(n2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// find the root node from the inorder list, then separate out the left, right part of both inorder and preorder list
// and do the same for left and right tree recursively
// Your code here along with comments explaining your approach

// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         // null case
//         if( preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
//             return null;
//         int rootValue = preorder[0];
//         TreeNode rootNode = new TreeNode(rootValue);
//         int rootIndex = -1;
//         for(int i = 0; i < inorder.length ; i ++){
//             if( inorder[i] == rootValue ){
//                 rootIndex = i;
//             }
//         }
//         int [] inLeft = Arrays.copyOfRange(inorder,0,rootIndex);
//         int [] inRight = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
//         int [] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
//         int [] preRight = Arrays.copyOfRange(preorder,inLeft.length+1, preorder.length);
//         rootNode.left = buildTree(preLeft, inLeft);
//         rootNode.right = buildTree(preRight, inRight);
//         return rootNode;
//     }
// }