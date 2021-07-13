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