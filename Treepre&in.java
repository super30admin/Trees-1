// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// We are storing the inorder array in a hash set with val and index.
// the first element in the preorder is the root element. we have a idx pointer which iterates on the preorder to give the root at each place.
// the recurssion takes care of left or right to be called.
// we find the root element using the idx variable and search that number in the hashset to get the index.
// for the left sub tree the start and end index in an inorder array is 0 - rootvalindex-1
// for the right sub tree rootvalindex+1 - end (length of the array-1)

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
    int idx;
     HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     this.map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder,int start,int end){
        //base
        if(start>end) return null;

        //logic
        int rootval= preorder[idx];
        idx++;
        TreeNode root=new TreeNode(rootval);
        int rootidx= map.get(rootval);
        root.left= helper(preorder,start,rootidx-1);
        root.right= helper(preorder,rootidx+1,end);
        return root;
    }
}