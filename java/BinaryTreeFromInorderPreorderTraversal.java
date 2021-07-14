## Problem 2

        https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

        Given preorder and inorder traversal of a tree, construct the binary tree.



        Note:
        You may assume that duplicates do not exist in the tree.

        Can you do it both iteratively and recursively?

        For example, given

        preorder = [3,9,20,15,7]


        inorder = [9,3,15,20,7]
        Return the following binary tree:

        3


        / \


        9  20


        /  \


        15   7

Approach 1
// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int preindex=0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1);
    }

    public TreeNode build(int [] preorder,int low,int high){
        if(low>high){
            return null;
        }
        int index=map.get(preorder[preindex]);
        TreeNode root = new TreeNode(preorder[preindex++]);

        root.left=build(preorder,low,index-1);
        root.right=build(preorder,index+1,high);
        return root;

    }
}

-----------------------------------------------------------------------------
Approach 2
// Time Complexity : O(N2)
// Space Complexity :O(N2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We get the root value from preorders first element and search for that element in inorder and everything left of that index in order would be inleft and right is inRight
Preorder's preleft would be after the firt element until the length of index found until inorder's rootVal and elements after that would give preRight
build Tree by reducing the array size in each recursive call
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
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0)
            return null;
        //find root in preorder
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx =0;
        //search root in Inorder
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal)
                rootIdx = i;
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}