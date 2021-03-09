// Time Complexity : O(n)
// Space Complexity : O(2n) => O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
Instead of having extra arrays space and 4 pointers, reduce it to 3 pointers of inStart, inEnd and preIndex.
And reduce the search complexity of inorder index to O(1) using HashMap.
The elements after the index goes to the right binary substructure and below that goes to the left binary substructure.
The base condition would be if the index reaches beyond their limit i.e. start is greater than end, then it is a null value.
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
    private HashMap<Integer,Integer> map;
    private int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder == null) return null;
        map = new HashMap<>();
        preIndex = 0;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return binaryTree(preorder,inorder,0,inorder.length-1);
    }
    
    public TreeNode binaryTree(int[] preorder,int[] inorder,int inStart,int inEnd){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = map.get(preorder[preIndex]);
        preIndex++;
        root.left = binaryTree(preorder,inorder,inStart,index-1);
        root.right = binaryTree(preorder,inorder,index+1,inEnd);
        return root;
        
    }
}
