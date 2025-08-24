// Time Complexity: O(N) where N is the number of nodes in the binary tree 
// Space Complexity: O(H)+O(N) where H is the height of the binary tree, which is recursive stack space and N is the space for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * The HashMap is used to keep track of the index of the root in inorder traversal in the current recursive call.
 * With each recursive call the pointer to the root in preorder traversal is incremented to get the next root.
 * The core logic used here is that in preorder traversal, the first element is always the root and in inorder traversal, the elements to the left of the root are part of the left subtree and the elements to the right of the root are part of the right subtree.
 * The base case is used to stop the recursion when the start index is greater than the end index which means when we hit the leafnode. Once the left subtree is built, the right subtree is built using the same logic.
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
    HashMap<Integer,Integer> inorderMap=new HashMap<>();
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++)
        {
            inorderMap.put(inorder[i],i);
        }

        return helper(0,inorder.length-1,preorder);
        

    }
    private TreeNode helper(int startIndex,int endIndex,int[] preorder)
    {
        if(startIndex>endIndex)  return null;
        int rootVal=preorder[idx];
        int rootIdx=inorderMap.get(rootVal);
        idx+=1;

        TreeNode root=new TreeNode(rootVal);
        root.left=  helper(startIndex,rootIdx-1,preorder);
        root.right=  helper(rootIdx+1,endIndex,preorder);

        return root;



    }





}