//approach-we are given with pre-order and in order traversal and we have to create a binary tree based on those traversals. the 1st element in preorder traversal would be the root and we find the root in inorder, by doing this, everything left to root in inorder is left subtree and towards right is right subtree. now we get the same length of left pre-order subtree by taking the same amount of nodes in preorder after the root as the left subtree we got from inorder and the rest of elements is right pre-order subtree. now we left and right pre-order and inorder traversal of the subtree. we recursively build left and right subtree while updating the root.left and root.right accordingly.
//time complexity-O(2n)->O(n) as we are processing each node once.
//space complexity=O(n+h) as n is to store nodes from inorder onto the map, h-> the most we would have each time in the recursive stack is the height of the tree,which is logn in balanced trees and n in skewed tree.
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
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx=0;
        this.map=new HashMap<>();
        //put inorder in a map with indexes to have quick lookup.
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
       return helper(inorder,0,inorder.length-1,preorder);
    }
    private TreeNode helper(int[] inorder,int start,int end,int[] preorder){
        if(start>end)return null;//no elements exists
        
        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        int index=map.get(root.val);//to get the index of the element from inorder[]
       root.left= helper(inorder,start,index-1,preorder);// left subtree
       root.right= helper(inorder,index+1,end,preorder);//right subtree
       return root;
    }
}
