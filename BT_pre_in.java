//T.C: O(n) n:elements in the tree
//S.c: O(n) = O(n) + O(h) HashMap of size n to store node with its position and function stack
//of size h.
/*Approach: Initially i will populate my HashMap with values and index from 
inorder[].
I will have a helper function to build the tree. get the first element from preorder
which would be root and then find the position of the root in the inorder and by that i 
would get the range of left subtree as well right. then i will build my left and right 
subtree by recursively calling my helper function and specifiying the range for ledt tree as well right.
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

        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int i =0;i < inorder.length; i++)
            hmap.put(inorder[i], i);
        
        int[] pre = {0};
        return helper(hmap, pre, preorder, 0, inorder.length - 1);
    }


    private TreeNode helper(HashMap<Integer,Integer> hmap, int[] pre, int[] preorder, int start, int end){
        
        
        if(start > end) return null;

        int rootVal = preorder[pre[0]];
        pre[0]++;

        int index = hmap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);


       root.left = helper(hmap, pre, preorder, start, index - 1);
        root.right = helper(hmap, pre, preorder, index + 1 , end);

        return root;
    }
}