// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
    //Hashmap to keep track of values and index in inorder array
    Map<Integer, Integer> map;
    //pointer for preorder array
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Preorder pointer will start from 0
        idx = 0;
        map = new HashMap<>();

//Putting all elements and it index into hashmap from inorder
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        
//Calling recursive function which will return root node
        return helper(preorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        //base condition
        if(start>end) return null;

        
        //Get the root value from preorder and increment preorder pointer
        //Get the index of root in inorder from hashmap

        int rootval = preorder[idx];
        int rootidx = map.get(rootval);
        idx++;
        TreeNode node = new TreeNode(rootval);

//Left recursion where start would be same and end would be index of root in inorder -1
//Similarly for right recursion
        node.left = helper(preorder, start, rootidx-1 );
        node.right = helper(preorder, rootidx+1, end );

        return node;
    }
}